<%--
  Created by IntelliJ IDEA.
  User: Prakash
  Date: 5/09/2022
  Time: 11:35 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>View Image</title>
</head>

<body>

<b>View | <a href="addPhoto.jsp">Upload</a></b><br/><br/>

<%
    String id = request.getParameter("id");
%>
<img src="getImage.jsp?id=<%=id%>" width="400px"/>

</body>
</html>