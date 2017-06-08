package com.ecommerce.dao;

import com.ecommerce.dto.*;

import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OrderDaoImpl implements OrderDao {
	
	@Resource(name="sessionFactory")
    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
           this.sessionFactory = sessionFactory;
    }
   
    protected Session getSession(){
           return sessionFactory.openSession();
    }
	@Override
	public Order registerOrder(Order order) {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
					
			if (session == null){
				return null;
			}else{
				session.beginTransaction();
				session.saveOrUpdate(order);
				session.getTransaction().commit();
				
				//Query to obtain new order number
				
//				Query query = session.createQuery("from orders by order_number DESC");
//				//query.setMaxResults(1);
//				int newOrder =  (int) query.uniqueResult();
//				session.close();
				return order;
				
			}
		}
	

	@Override
	public List<Item> searchItems(String order_number) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//Query using Hibernate Query Language
		String SQL_QUERY =" from order_detail as od inner join order as o on od.order_id = o.order_id and o.order_number like ?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0,"%"+order_number+"%");
		@SuppressWarnings("unchecked")
		List<Item> list = query.list();
		session.close();
		return list;
		}
	}
	




