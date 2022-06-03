<%--
  Created by IntelliJ IDEA.
  User: Prakash
  Date: 5/08/2022
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h1>Welcome to WUMP APP</h1>
    <form action="<%=request.getContextPath()%>/validatelogin" method="post">
        <table style="with: 100%">
            <tr>
                <td>email</td>
                <td><input type="text" name="email" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" /></td>
            </tr>

        </table>
        <input type="submit" name = "first" value="Sign In" />
        <input type="submit" name = "second" value="Sign Up" />
    </form>
</div>


</body>
</html>
