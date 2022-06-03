<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Final Project Database</title>
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
				<a href="https://www.xadmin.net" class="navbar-brand"> Final Project - WUMP </a>
			</div>

			<ul class="navbar-nav">
				<a href="<%=request.getContextPath()%>/list" class="btn btn-success">show all data</a>

				<a href="<%=request.getContextPath()%>/logout" class="btn btn-success">Logout</a>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Data List</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add	New Data</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Area(cm2)</th>
						<th>Objects Found</th>
						<th>temperature</th>
						<th>Longitude</th>
						<th>Latitude</th>
						<th>weather</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="user" items="${listUser}">

						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.area}"/></td>
							<td><c:out value="${user.object}"/></td>
							<td><c:out value="${user.temperature}" /></td>
							<td><c:out value="${user.longitude}" /></td>
							<td><c:out value="${user.latitude}" /></td>
							<td><c:out value="${user.weather}" /></td>
							<td><a href="edit?id=<c:out value='${user.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${user.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>

	<br>
	<br>
	<br>

<br>
<br>
<br>
	<div align="center">
	<title>View Image</title>
	</head>

	<body>

	<b>View Photo By Experiment ID</b><br/><br/>

	<form action="viewImage.jsp" method="post">
		<input type="text" name="id" required="required" placeholder="enter experiment id.."/><br/><br/>
		<input type="submit"/>
	</form>



	</div>






</body>
</html>