package com.ecommerce.dao;
import java.util.List;
import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ecommerce.dto.*;

public class MyAccountDaoImpl implements MyAccountDao {

	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	@Override
	public List<Object[]> searchOrderbyUser(int userid) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// Query using Hibernate Query Language
		SQLQuery query = session.createSQLQuery("select o.order_number,p.code, p.product_name,  i.quantity, i.price from items i inner join orders o on i.order_number = o.order_number inner join products as p "
				+ "on i.product_id = p.product_id where o.user_id =?");
		/*query.addEntity(Item.class);
		query.addEntity(Order.class);
		query.addEntity(Product.class);
	*/	query.setParameter(0,userid );
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.list();
		session.close();
		return list;
	}

}
