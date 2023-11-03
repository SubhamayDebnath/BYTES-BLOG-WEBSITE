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
    <link rel="stylesheet" href="css/profile.css">
    <title>BYTES-Profile Edit</title>
</head>
<body>
    <div class="main-box">
        <div class="box2">
            <div class="upper">
                <h4> edit account</h4>
            </div>
           <div class="line"></div>
           <div class="result">
           <c:if test = "${not empty uwMsg }">
        <h5>${uwMsg}</h5>
        <c:remove var="uwMsg"/>
        </c:if>
           </div>
            <form action="Update" method="post" class="form" enctype="multipart/form-data">
                <label for="file">Profile</label>
                <input type="file" name="image" id="file">
                <label for="firstname">First Name</label>
                <input type="text" name="user_firstname" id="firstname" value="<%=user.getFirstname() %>" placeholder="Enter Your First name">

                <label for="lastname">Last Name</label>
                <input type="text" name="user_lastname" id="lastname" value="<%=user.getLastname() %>"  placeholder="Enter Your Last Name">
   
                <label for="dob">DOB</label>
                <input type="date" name="user_dob" id="dob" value="<%=user.getDob() %>">

                <label for="email">Email</label>
                <input type="email" name="user_email" id="email" value="<%=user.getEmail() %>"  placeholder="Enter Your Email">

                <label for="password">Password</label>
                <input type="text" name="user_password" value="<%=user.getPassword() %>"  id="password" placeholder="Enter Your Password">
               
                <div class="div">
                    <a href="userprofile.jsp">Back</a>
                    <input type="reset" value="Clear" id="submit">
                    <input type="submit" name="submit" value="Save" id="submit">
                </div>
                
            </form>
        </div>
    </div>
</body>
</html>