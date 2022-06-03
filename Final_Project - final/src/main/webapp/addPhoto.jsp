<%--
  Created by IntelliJ IDEA.
  User: Prakash
  Date: 5/12/2022
  Time: 10:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="PhotoServlet" enctype="multipart/form-data">
    <div>
        <label>Experiment Photo: </label>
        <input type="file" name="photo" size="50" />
    </div>
    <input type="submit" value="Save">
</form>


</body>
</html>
