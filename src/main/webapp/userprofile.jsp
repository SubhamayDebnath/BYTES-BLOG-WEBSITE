<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %>
    <%@page import="com.connection.DBConnect" %>
    <%@page import="com.entity.User" %>
    <%@page import="com.dao.UserDAO" %>
<%
    User user = (User) session.getAttribute("currentUser");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/userprofile.css">
    <title>Bytes-<%=user.getFirstname() %></title>
</head>
<body>
    <div class="main-box">
        <div class="box">
            <div class="upper">
              <h1>My Account</h1>
            </div>
            <div class="line"></div>
            <div class="profile">
                <div class="pic-info">
                  <img src="img/<%=user.getProfile() %>" alt="">
                </div>
                <div class="info">
                    <div class="user-info">
                            <h2>First Name:<span><%=user.getFirstname() %></span></h2>
                            <h2>Last Name:<span><%=user.getLastname() %></span></h2>
                            <h2>DOB:<span><%=user.getDob()%></span></h2>
                            <h2>Email:<span><%=user.getEmail() %></span></h2>
                    </div>
                    <div class="btn">
                        <a href="profileedit.jsp">Edit</a>
                        <a href="home.jsp">Back</a>
                    </div>
                </div>
                    
            </div>
        </div>
    </div>
</body>
</html>