package com.ecommerce.dao;

import com.ecommerce.dto.*;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductDaoImpl implements ProductDao {
	
	@Resource(name="sessionFactory")
    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
           this.sessionFactory = sessionFactory;
    }
   
    protected Session getSession(){
           return sessionFactory.openSession();
    }

	@Override
	public List<Product> searchProduct(String search) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//Query using Hibernate Query Language
		String SQL_QUERY =" from Product as p where p.description like ?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0,"%"+search+"%");
		@SuppressWarnings("unchecked")
		List<Product> list = query.list();
		session.close();
		return list;
		}
	}




