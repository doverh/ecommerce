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
	public boolean registerItem(Item item, int productId) {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
					
			if (session == null){
				return false;
			}else{
				item.setProduct_id(productId);
				session.beginTransaction();
				session.saveOrUpdate(item);
				session.getTransaction().commit();
				session.close();
				return true;
			}
		}
}
	


