<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.sql.*" %>
     <%@page import="com.dao.BlogDAO" %>
     <%@page import="com.connection.DBConnect" %>
     <%@page import="java.util.ArrayList" %>
     <%@page import="com.entity.Category" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="Stylesheet" href="css/dopost.css">
    <title>BYTES-Post</title>
    </head>
<body>
    <div class="dopost">
        <div class="post-head">
            <span>Post</span>
        </div>
        <div class="result">
        <c:if test = "${not empty postMsg }">
        <h5>${postMsg}</h5>
        <c:remove var="postMsg"/>
         </c:if>
        </div>
        <form action="PostBlog" method="post" enctype="multipart/form-data">
            <select id="cat" name="cid" required>
                <option selected disabled >Select Catagory</option>
                 <%
                BlogDAO postn =new BlogDAO(DBConnect.getConn());
                ArrayList<Category> list= postn.getCategories();
               
                	for(Category cy : list)
                	{
                %>
                <option value="<%= cy.getCid()%>"><%=cy.getCname() %></option>
                <%
                	}
                %>
            </select>
            <textarea name="btittle" id="tittle" cols="50" rows="1" placeholder="Enter Tittle" required></textarea>
            <textarea name="bcont" id="cont" cols="50" rows="10"placeholder="Enter Content"required></textarea>
            <input type="file" name="bpic" id="pic" required>
            <div class="post-btn">
                <a href="home.jsp">back</a>
                <input type="reset" value="Clear" id="new">
                <input type="submit" value="post" id="new">
                
            </div>
        </form>
        
    </div>
    
</body>
</html>