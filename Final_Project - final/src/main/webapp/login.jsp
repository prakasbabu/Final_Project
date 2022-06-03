<%--
  Created by IntelliJ IDEA.
  User: Prakash
  Date: 5/6/2022
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

<h1> Account Login</h1>

<p>${error}</p>

<form method="post" action="/login">

    <label for="username">username:</label>
    <input type="text" id="username" name="username"><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password"><br>

    <button type="submit">Login</button>             <button type="submit">Sign UP</button>
</form>




</body>
</html>

