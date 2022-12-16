<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
			<img src="images/h1.png" alt="No-image" class="rounded"
				width="100px" height="70px">
				
			<ul class="nav">
				<li class="nav-item"><button type="button"
						class="btn btn-primary" data-toggle="modal" data-target="#myModal">Login</button>&nbsp;&nbsp;&nbsp;
				<li class="nav-item"><button type="button"
						class="btn btn-primary" data-toggle="modal"
						data-target="#myModal1">SignUp</button>&nbsp;&nbsp;&nbsp;
			</ul>
		</div>
	</nav>
	<br><br>

<center>
		<h1 class="text-info">Welcome To Online Furniture Shopping</h1>
</center>
<br>
	<!-- carosal -->
	<div id="demo" class="carousel slide" data-ride="carousel">
		<center>
			<ul class="carousel-indicators">
				<li data-target="#demo" data-slide-to="0" class="active"></li>
				<li data-target="#demo" data-slide-to="1"></li>
				<li data-target="#demo" data-slide-to="2"></li>
				<li data-target="#demo" data-slide-to="3"></li>
				<li data-target="#demo" data-slide-to="4"></li>
			</ul>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="images/c1.jpg" alt="Offers" width="500" height="250">
				</div>
				<div class="carousel-item">
					<img src="images/c2.jpg" alt="Offers" width="500" height="250">
				</div>
				<div class="carousel-item">
					<img src="images/s1.jpg" alt="Bed" width="350" height="250">
				</div>
				<div class="carousel-item">
					<img src="images/b1.jpg" alt="Bed" width="350" height="250">
				</div>
				<div class="carousel-item">
					<img src="images/o1.jpg" alt="Office" width="450" height="250">
				</div>
				<div class="carousel-item">
					<img src="images/st1.jpg" alt="Storage" width="450" height="250">
				</div>
			</div>
			<a class="carousel-control-prev" href="#demo" data-slide="prev">
				<span class="carousel-control-prev-icon"></span>
			</a> <a class="carousel-control-next" href="#demo" data-slide="next">
				<span class="carousel-control-next-icon"></span>
			</a>
		</center>
	</div>

	<!-- Dropdown Element -->
	<div class="container">
		<form action="show" method="post">
			<div class="row">

				<div class="col-sm-3">
					Select Category : <select name="category"
						class="form-control col-sm-9" style="width: 200px;">
						<option value="-1">SelectCategory</option>
						<c:forEach items="${categoryList}" var="cl">
							<option value="${cl}">${cl}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-sm-0">
					<br> <input type="submit" class="btn btn-primary"
						name="action" value="Go" style="float: center;" />
				</div>
			</div>
		</form>
	</div>
	<br>

	<div class="container">
		<table class="table table-condensed" border="2">
			<tr>
				<th>Image</th>
				<th>ProductName</th>
				<th>Price</th>
			</tr>
			<c:forEach items="${productList}" var="il">
				<tr>
					<td><img src="images/${il.imageUrl}" width="90px"
						height="90px"></td>
					<td>${il.name}</td>
					<td>${il.price}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Enter Login Details</h4>
					<form action="show" method="post">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					Enter E-mail:<input type="email" name="E-mail" class="form-control"
						placeholder="Enter Email" required><br> Enter password:<input
						type="password" name="Password" class="form-control"
						placeholder="Enter password" required><br>
				</div>
				<div class="modal-footer">
					<input type="submit" class="btn btn-primary" name="action"
						value="Login" />
					</form>
				</div>
			</div>

		</div>
	</div>

	<div id="myModal1" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">

				<div class="modal-header">

					<h4 class="modal-title">Enter Registration Details!</h4>
					<form action="show" method="post">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					Enter Name:<input type="text" name="name" class="form-control"
						placeholder="Enter name" required><br> Enter E-mail:<input
						type="email" name="E-mail" class="form-control"
						placeholder="Enter Email" required><br> Enter password:<input
						type="password" name="Password" class="form-control"
						placeholder="Enter password" required><br>
				</div>
				<div class="modal-footer">

					<input type="submit" class="btn btn-primary" name="action"
						value="Register" required/>
					</form>
				</div>
			</div>

		</div>
	</div>
	</form>

</body>
</html>
