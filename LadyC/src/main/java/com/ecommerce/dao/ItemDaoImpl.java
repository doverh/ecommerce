package com.ecommerce.dao;

import com.ecommerce.dto.*;


import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ItemDaoImpl implements ItemDao {
	
	@Resource(name="sessionFactory")
    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
           this.sessionFactory = sessionFactory;
    }
   
    protected Session getSession(){
           return sessionFactory.openSession();
    }
	@Override
	public Item registerItem(Item item) {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
					
			if (session == null){
				return null;
			}else{
				session.beginTransaction();
				session.saveOrUpdate(item);
				session.getTransaction().commit();
				return item;
			}
		}
}
	


