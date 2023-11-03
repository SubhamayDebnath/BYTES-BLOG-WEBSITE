<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/lscss.css">
    <title>BYTES-Sign Up</title>
</head>
<body>
    <div class="main-box" id="main-box">
        <div class="left-box">
            <div class="logo">
                <a href="home.jsp">Bytes</a>
            </div>
            <div class="mid-text">
                <h1>HELLO!</h1>
            </div>
            <div class="new-link">
                <a href="login.jsp">Log in</a>
            </div>
        </div>
        <div class="right-box">
            <div class="page-name">
                <h2>sign up</h2>
            </div>
            <div class="result">
                <h5>
                <c:if test = "${not empty eMsg }">
        <h5>${eMsg}</h5>
        <c:remove var="eMsg"/>
        </c:if>
                </h5>
            </div>
            <form action="RegServlet" method="post">
                <input type="text" name="firstname" id="firstname" placeholder="First Name" minlength="3" required>
                 <br>
                <input type="text" name="lastname" id="lastname" placeholder="Last Name" minlength="3" required>
                 <br>
                <input type="date" name="dob" id="dob" required>
                <br>
                <input type="email" name="email" id="email" placeholder="Email" required >
                 <br>
                <input type="password" name="password" id="password" placeholder="Password" minlength="6" required >
                  <br>
                <div class="sub">
                    <input type="submit" name="submit" value="sign up" id="submit">
                </div>
               
            </form>
            <div class="pagelink">
                <a href="login.jsp">Log In</a>
            </div>
        </div>
        
       
    </div>
     <script src="js/signup.js"></script>
</body>
</html>