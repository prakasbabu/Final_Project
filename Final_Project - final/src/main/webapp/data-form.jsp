

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Final Project Database form</title>
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
				<a href="https://www.xadmin.net" class="navbar-brand"> Final Project Database </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link" >Show all Data</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit User
            		</c:if>
						<c:if test="${user == null}">
            			Submit what you find here
            		</c:if>
					</h2>
				</caption>


				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>area</label> <input type="number"
						value="<c:out value='${user.area}' />" class="form-control"
						name="area" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>object</label> <input type="text"
						value="<c:out value='${user.object}' />" class="form-control"
						name="object">
				</fieldset>

					<fieldset class="form-group">
						<label>temperature</label> <input type="number"
												   value="<c:out value='${user.temperature}' />" class="form-control"
												   name="temperature" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>longitude</label> <input type="number"
												   value="<c:out value='${user.longitude}' />" class="form-control"
												   name="longitude" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>latitude</label> <input type="number"
												   value="<c:out value='${user.latitude}' />" class="form-control"
												   name="latitude" required="required">
					</fieldset>

					</fieldset class="form-group">
					<label>weather</label> <input type="text"
												 value="<c:out value='${user.weather}' />" class="form-control"
												 name="weather">
					</fieldset>

					<button type="submit" class="btn btn-success">Save</button>
					</form>


<br><br>
					<div align="center">

							<a href="addPhoto.jsp">Upload Experiment Photo</a>

					</div>







			</div>
		</div>
	</div>
</body>
</html>