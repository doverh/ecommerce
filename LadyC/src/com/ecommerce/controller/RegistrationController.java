package com.ecommerce.controller;

import com.ecommerce.dao.*;
import com.ecommerce.dto.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//This class takes input from Login.jsp page and controls the flow based on validation with database

public class RegistrationController extends HttpServlet {

private static final long serialVersionUID = 2562294252731783855L;

public void doPost(HttpServletRequest request, HttpServletResponse response) 
                    throws ServletException, java.io.IOException {

try{       
     User user = new User();
     user.setUsername(request.getParameter("username"));
     user.setPassword(request.getParameter("pwd"));
     user.setFirstname(request.getParameter("firstname"));
     user.setLastname(request.getParameter("lastname"));
     user.setEmail(request.getParameter("email"));
     user.setAddress(request.getParameter("address"));
     user.setCity(request.getParameter("city"));;
     user.setState(request.getParameter("state"));
     user.setPhone(request.getParameter("phone"));
     
     
     UserDao dao = new UserDaoImpl();
     dao.register(user);
                
     if (user != null)
     {
    	 response.sendRedirect("welcome.jsp"); //Send user to login page  
     }
           
     else {
          response.sendRedirect("invalid_login.jsp"); //error page 

     }
  } 
      
      
catch (IOException e){
	
     e.printStackTrace(); 
	}
       
  }
}