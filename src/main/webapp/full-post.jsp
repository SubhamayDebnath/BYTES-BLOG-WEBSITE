<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    int blogID=Integer.parseInt(request.getParameter("blog-id"));
    BlogDAO dy=new BlogDAO(DBConnect.getConn());
    Post py=dy.getPostByPostId(blogID);
    %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="css/full-post.css">
    <link rel="stylesheet" href="css/nav.css">
    <link rel="stylesheet" href="css/index.css">
    <title><%=py.getBtittle() %></title>
</head>
<body>
	<%@include file="nav.jsp"%>
    <div class="blog-container-p">
        <div class="main-box-p">
           <div class="blog-tittle-p">
            <h1><%=py.getBtittle() %></h1>
           </div>
           <div class="blog-pic-p">
            <img src="blogimg/<%=py.getBpic() %>" alt="">
           </div>
           <%
           UserDAO usr=new UserDAO(DBConnect.getConn());
           %>
           <div class="blog-owner-p">
            <h2>Posted by<a href="#"><%=usr.getUserByUserID(py.getUserid()).getFirstname()%></a></h2>
            <span></span>
           </div>
           <div class="blog-cont-p">
            <p><%=py.getBcont() %></p>
           </div>
        </div>
        <div class="comment-box-p">
            <textarea name="comment" id="comment" cols="30" rows="10" placeholder="Type your comment"></textarea>
            <input type="submit" name="submit" value="Post" id="submit">
        </div>
    </div>
    <%@include file="footer.jsp"%>
</body>
</html>