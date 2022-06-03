

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Final Project</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: blue">
        <div>
            <a href="https://www.xadmin.net" class="navbar-brand"> Register New User </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/register"
                   class="nav-link"></a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">

                <c:if test="${registeruser == null}">
                <form action="register" method="post">
                    </c:if>



                    <fieldset class="form-group">
                        <label>email</label> <input type="text"
                                                   value="<c:out value='${userDao.email}' />" class="form-control"
                                                   name="email" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>name</label> <input type="text"
                                                     value="<c:out value='${userDao.name}' />" class="form-control"
                                                     name="name">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>age</label> <input type="number"
                                                          value="<c:out value='${userDao.age}' />" class="form-control"
                                                          name="age" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>password</label> <input type="text"
                                                        value="<c:out value='${userDao.password}' />" class="form-control"
                                                        name="password" required="required">


                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>