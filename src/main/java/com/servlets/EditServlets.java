package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.connection.DBConnect;
import com.dao.UserDAO;
import com.entity.User;
import com.connection.PhotoWorker;
import java.sql.*;

@MultipartConfig
@WebServlet("/Update")
public class EditServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EditServlets() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
        	
            String userFirstname = request.getParameter("user_firstname");
            String userLastname = request.getParameter("user_lastname");
            String userDob = request.getParameter("user_dob");
            String userEmail = request.getParameter("user_email");
            String userPassword = request.getParameter("user_password");
            Part part = request.getPart("image");
            String imageName = part.getSubmittedFileName();
            
            HttpSession s = request.getSession();
            User user = (User) s.getAttribute("currentUser");
            
            user.setFirstname(userFirstname);
            user.setLastname(userLastname);
            user.setDob(userDob);
            user.setEmail(userEmail);
            user.setPassword(userPassword);
            String oldFile = user.getProfile();

            user.setProfile(imageName);

          
            UserDAO uDAO=new UserDAO(DBConnect.getConn());
            boolean resl=uDAO.updateUser(user);
            
            if(resl)
            {
            	 String path = request.getRealPath("/") + "img" + File.separator + user.getProfile();
            	 PhotoWorker.deleteFile(path);
            	 if(PhotoWorker.saveFile(part.getInputStream(), path)) {
            		 
            		 
            		 response.sendRedirect("userprofile.jsp");
            	 	}
            	 else
            	 {
            		 s.setAttribute("uwMsg", "Wrong");
            		 response.sendRedirect("profileedit.jsp");
            	 }
            	
         }	
            else
         {
         	 s.setAttribute("uwMsg", "Wrong");
        	 response.sendRedirect("profileedit.jsp");
         }

	}

	}
	
}
