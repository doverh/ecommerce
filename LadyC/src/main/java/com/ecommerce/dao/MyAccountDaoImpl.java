package com.ecommerce.dao;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
	public List searchOrderbyUser(int userid) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// Query using Hibernate Query Language
		String SQL_QUERY = "select o.order_number, p.product_name, p.code, i.quantity, i.price  "
				+ "from orders o inner join items i on o.order_number = i.order_number inner join products as p "
				+ "on i.product_id = p.product_id where o.user_id =?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0, "%" + userid + "%");
		@SuppressWarnings("unchecked")
		List list = query.list();
		session.close();
		return list;
	}

}
