<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.sql.*" %>
 <%@page import="com.connection.DBConnect" %>
 <%@page import="com.entity.User" %>
 <%@page import="com.dao.UserDAO" %>
 <%@page import="java.sql.*" %>
 <%@page import="com.dao.BlogDAO" %>
 <%@page import="java.util.ArrayList" %>
 <%@page import="com.entity.Category" %>
 <%@page import="java.sql.*" %>
 <%@page import="com.entity.Post" %>
 <%@page import="java.util.*" %>
<%
    User user = (User) session.getAttribute("currentUser");
%>


<body>
    <div class="navbar">
        <div class="logo">
            <a href="home.jsp">bytes</a>
        </div>
        <div class="options">

            <div class="menutoggle active">
                <i class="fa fa-bars"></i>
            </div>
            <div class="menu">
                <ul class="navlist active">
                    <li><a href="">Reviews</a></li>
                    <li><a href="">Software</a></li>
  					<li><a href="">Games</a></li>
                    <li><a href="dopost.jsp">Post</a></li>
                    <li><a href="userprofile.jsp"><%= user.getFirstname() %></a></li>
                    
                </ul>
            </div>
        </div>
        
    </div>
    <!--  -->
    <script src="js/nav.js"></script>
</body>