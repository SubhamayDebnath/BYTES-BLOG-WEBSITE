<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/index.css">
     <link rel="stylesheet" href="css/new.css">
    <link rel="stylesheet" href="css/nav.css">
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>BYTES-Home</title>
</head>
<body>
	<%@include file="nav.jsp"%>
    <div class="post-container">
    <%
    BlogDAO c= new BlogDAO(DBConnect.getConn());
    List<Post> posts =c.getAllPost();
    for(Post p: posts)
    {
    %>
   		 <div class="post">
            <img src="blogimg/<%=p.getBpic() %>" alt="">
            <div class="blog-text">
            <a href="full-post.jsp?blog-id=<%= p.getBid() %>"><%=p.getBtittle() %></a>
             <div class="btn">
                    <a href="full-post.jsp?blog-id=<%= p.getBid() %>">more</a>
              </div>
            </div>
           
        </div>
        <%
    }
        %>
    </div>
    <%@include file="footer.jsp"%>
</body>
</html>