<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visit Again</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body style="background-color: #d5f4e6">
	<nav class="navbar" style="background-color: #80ced6;">
		<div class="container">
			<img src="images/h1.png" alt="No-image" class="img-thumbnail"
				width="80px" height="80px">
			<ul class="nav">
				<li class="nav-item"><button type="button"
						class="btn btn-primary">Welcome ${user}</button>&nbsp;&nbsp;&nbsp;
				
				<li class="nav-item"><a class="btn btn-primary"
					href="logout.jsp">Logout</a>&nbsp;&nbsp;&nbsp;
			</ul>
		</div>
	</nav>
	<br>
	<center>

	<center>
		<h1 style="color: blue">
			<b>Order Successful & Visit Again....! </b>
		</h1>
	</center>

</body>
</html>