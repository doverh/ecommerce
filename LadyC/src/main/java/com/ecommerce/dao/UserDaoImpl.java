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
	
	
	
	@SuppressWarnings("null")
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

//Method to validate username and password
//public boolean validateUser(User user) {        
//  boolean status = false;
//  Connection conn = null;
//  PreparedStatement pst = null;
//  ResultSet rs = null;
//
//  String url = "jdbc:mysql://localhost:8080/";
//  String dbName = "virtual_store";
//  String driver = "com.mysql.jdbc.Driver";
//  String userName = "root";
//  String password = "Dovico#29";
//  try {
//      Class.forName(driver).newInstance();
//      conn = (Connection) DriverManager
//              .getConnection(url + dbName, userName, password);
//
//      pst = conn
//              .prepareStatement("select * from users where user=? and password=?");
//      pst.setString(1, user.getUsername());
//      pst.setString(2, user.getPassword());
//
//    
//      rs = (ResultSet) pst.executeQuery();
//      status = rs.next();
//
//  } catch (Exception e) {
//      System.out.println(e);
//  } finally {
//      if (conn != null) {
//          try {
//              conn.close();
//          } catch (SQLException e) {
//              e.printStackTrace();
//          }
//      }
//      if (pst != null) {
//          try {
//              pst.close();
//          } catch (SQLException e) {
//              e.printStackTrace();
//          }
//      }
//      if (rs != null) {
//          try {
//              rs.close();
//          } catch (SQLException e) {
//              e.printStackTrace();
//          }
//      }
//  }
//  return status;
//}
//



