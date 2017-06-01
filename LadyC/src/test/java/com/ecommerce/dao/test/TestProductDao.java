package com.ecommerce.dao.test;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import static org.junit.Assert.*;

import com.ecommerce.dto.Product;

public class TestProductDao {

	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	@Test
	public void testSearchProduct() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// Query using Hibernate Query Language
		String SQL_QUERY = " from Product as p where p.description like ?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0, "%" + "Boots" + "%");
		@SuppressWarnings("unchecked")
		List<Product> list = query.list();
		assertEquals("Black Leather Boots", list.get(0).getProduct_name());
		session.close();

	}

}
