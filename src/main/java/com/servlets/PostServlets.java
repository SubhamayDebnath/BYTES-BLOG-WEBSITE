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
import java.sql.Timestamp;
import com.connection.DBConnect;
import com.connection.PhotoWorker;
import com.dao.BlogDAO;
import com.entity.Post;
import com.entity.User;
import java.sql.*;


@MultipartConfig
@WebServlet("/PostBlog")
public class PostServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public PostServlets() {
        super();
     
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
        	int cid = Integer.parseInt(request.getParameter("cid"));
            String btittle = request.getParameter("btittle");
            String bcont = request.getParameter("bcont");
            
            Part part = request.getPart("bpic");
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("currentUser");
            Post p = new Post( btittle, bcont,null, part.getSubmittedFileName(), cid, user.getId());
            BlogDAO dao=new BlogDAO(DBConnect.getConn());
            if (dao.savePost(p)) {

                String path = request.getRealPath("/") + "blogimg" + File.separator + part.getSubmittedFileName();
                PhotoWorker.saveFile(part.getInputStream(), path);
                response.sendRedirect("home.jsp");
            } else {
            	  session.setAttribute("postMsg", "Something went wrong");
            	response.sendRedirect("dopost.jsp");
            }
        }
	}

	
}
