package com.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.connection.DBConnect;
import com.dao.UserDAO;
import com.entity.User;

@WebServlet("/LoginSer")
public class LoginServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlets() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()){
        	
	        	  String userEmail = request.getParameter("email");
	              String userPassword = request.getParameter("password");

	              UserDAO dao = new UserDAO(DBConnect.getConn());

	              User u = dao.getUserByEmailAndPassword(userEmail, userPassword);
	              HttpSession s =request.getSession();

	              if (u == null) {

	            	    s.setAttribute("wrongMsg", "Wrong User");
	        			response.sendRedirect("login.jsp");
	        			

	              } else {

	            	  
	            	
	            	  	s.setAttribute("currentUser", u);
		                response.sendRedirect("home.jsp");

	              }
	        }
		
		
	}

}
