<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" href="css/lscss.css">
    <title>BYTES-Log In</title>
</head>
<body>
    <div class="main-box">
        <div class="left-box">
            <div class="logo">
                <a href="home.jsp">Bytes</a>
            </div>
            <div class="mid-text">
                <h1>WELCOME</h1>
            </div>
            <div class="new-link">
                <a href="signup.jsp">New Account</a>
            </div>
        </div>
        <div class="right-box">
            <div class="page-name">
                <h2>log in</h2>
            </div>
            <div class="result">
        <c:if test = "${not empty wrongMsg }">
        <h5>${wrongMsg}</h5>
        <c:remove var="wrongMsg"/>
        </c:if>
            </div>
            <form action="LoginSer" method="post" class="form"  id="Form">
                <input type="email" name="email" id="email" placeholder="Email" required autocomplete="off" onkeydown="validation()">
                <div id="text" ></div>
                <input type="password" name="password" id="password" placeholder="Password" required minlength="6" autocomplete="off" onkeyup="msg(this.value)">
                <div id="error"></div>
                <input type="submit" name="submit" value="log in" id="submit">
            </form>
            <div class="pagelink">
                <a href="signup.jsp">New Account</a>
            </div>
            
        </div>
    </div>
    <script src="js/login.js"></script>
</body>
</html>