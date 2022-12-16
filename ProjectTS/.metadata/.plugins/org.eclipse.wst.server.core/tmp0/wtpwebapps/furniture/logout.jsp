<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
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
				<li class="nav-item">
					<form action="show" method="get">
						<input type="submit" class="btn btn-primary" name="rehome"
							value="Homepage" />&nbsp;&nbsp;&nbsp;
					</form>
			</ul>
		</div>
	</nav>

	<%
		session.invalidate();
	%>
	<center>
		<h1 style="color: blue">
			<b>LoggedOut Successfully</b>
		</h1>
	</center>
</body>
</html>