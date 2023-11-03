package com.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import com.connection.DBConnect;
import com.dao.UserDAO;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/RegServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegistrationServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
        	 String firstname = request.getParameter("firstname");
        	 String lastname = request.getParameter("lastname");
        	 String dob=request.getParameter("dob");
        	 String email = request.getParameter("email");
             String password = request.getParameter("password");
             User user=new User(firstname,lastname,dob,email,password);
             UserDAO dao = new UserDAO(DBConnect.getConn());
             HttpSession session =request.getSession();
             if (dao.addUser(user)) {
            	 
     			response.sendRedirect("login.jsp");

             } else {
            	 session.setAttribute("eMsg","Something went wrong");
     			response.sendRedirect("signup.jsp");
             }
        	
        }
	}

}
