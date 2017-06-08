package com.ecommerce.dao;

import com.ecommerce.dto.*;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserDaoImpl implements UserDao {
	
	@Resource(name="sessionFactory")
    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
           this.sessionFactory = sessionFactory;
    }
   
    protected Session getSession(){
           return sessionFactory.openSession();
    }
	
	
	

	@Override
	public boolean register(User user) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
				
		if (session == null){
			return false;
		}else{
			session.beginTransaction();
			session.saveOrUpdate(user);
			session.getTransaction().commit();
			session.close();
			return true;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public User validateUser(String username, String password) {
		User user = null;
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//Query using Hibernate Query Language
		String SQL_QUERY =" from User as o where o.username=? and o.password=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0,username);
		query.setParameter(1,password);
		List<User> list = query.list();

		if ((list != null) && (list.size() > 0)) {
			user = list.get(0);
		}
		session.close();
		return user;
		}
	}




