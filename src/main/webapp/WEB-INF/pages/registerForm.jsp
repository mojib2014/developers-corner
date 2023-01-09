<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.js"
	type="text/javascript"></script>
<script src="/static/js/app.module.js" type="text/javascript"></script>
<script src="/static/js/service/user.service.js" defer
	type="text/javascript"></script>
<script src="/static/js/controller/user.controller.js" defer
	type="text/javascript"></script>
	<script src="/static/js/activeNavLinks.js" type="text/javascript" defer></script>
<link href="/static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="/static/css/styles.css" rel="stylesheet" type="text/css">
<title>Developers Corner | Register Page</title>
</head>
<body data-ng-app="developersCorner" class="ng-cloak">
		<header>
		<div class="container">
			<nav>
				<a class="logo" href="/">Developers Corner</a>
				<ul>
					<li><a href="/">Home</a></li>
					<li><a href="/login">Login</a></li>
					<li><a href="/chat">Chat</a></li>
					<li><a href="/register">Register</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<main class="main" ng-controller="UserController">
		<div class="container">
			<div class="panel panel-default">
				<div class="panel-heading mb-3">
					<h2>User Registration Form</h2>
				</div>
				<div class="form-container">
					<form ng-submit="submit()" name="registerForm" class="form-horizontal" novalidate>
						<input type="hidden" ng-model="user.id" />

						<div class="input-group mb-3">
							<span class="input-group-text" id="basic-addon1">
								<svg
										xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
		 			 				<path
											d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 
											1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 
											10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z" 
									/>
								</svg>
							</span> 
							<input type="text" ng-model="user.firstName" name="firstName"
								class="form-control" placeholder="John" aria-label="First Name"
								aria-describedby="basic-addon1" required ng-minlength="5"
								required />
						</div>
						<!-- First name errors -->
						<div class="alert alert-danger"
							ng-show="registerForm.firstName.$touched && registerForm.firstName.$error.required">
							This is a
							required field
						</div>
						<div class="alert alert-danger"
							ng-show="registerForm.firstName.$error.minlength">Minimum
							length required is 5
						</div>

						<div class="input-group mb-3">
							<span class="input-group-text" id="basic-addon1"> 
								<svg
									xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
	  								<path
										d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z" />
								</svg>
							</span> 
							<input type="text" ng-model="user.lastName" name="lastName"
								class="form-control" placeholder="Doe" aria-label="Last Name"
								aria-describedby="basic-addon1" required ng-minlength="5" />
						</div>
						<!-- Last Name errors -->
						<div class="alert alert-danger"
							ng-show="registerForm.lastName.$touched && registerForm.lastName.$error.required">
							This is a
							required field
						</div>
						<div class="alert alert-danger"
							ng-show="registerForm.lastName.$error.minlength">
							Minimum
							length required is 5
						</div>
						<div class="alert alert-danger"
							ng-show="registerForm.$error.email">
							This field is invalid
						</div>

						<div class="input-group mb-3">
							<span class="input-group-text" id="basic-addon1">@</span> 
							<input
								type="email" ng-model="user.email" name="email"
								class="form-control" placeholder="email@example.com"
								aria-label="Email" aria-describedby="basic-addon1" required
							/>
						</div>
						<!-- Email errors  -->
						<div class="alert alert-danger"
							ng-show="registerForm.email.$touched && registerForm.email.$error.required">
							This is a
							required field
						</div>
						<div class="alert alert-danger"
							ng-show="registerForm.$error.email">
							This field is invalid
						</div>

						<div class="input-group mb-3">
							<span class="input-group-text" id="basic-addon1">
							<svg
									xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-lock" viewBox="0 0 16 16">
	  						<path
										d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2zM5 8h6a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1V9a1 1 0 0 1 1-1z" />
							</svg>
							</span> 
							<input type="password" ng-model="user.password" name="password"
								class="form-control" placeholder="m@2#ac%" aria-label="Password"
								aria-describedby="basic-addon1" required ng-minlength="6"
							/>
						</div>
						<!-- Password errors  -->
						<div class="alert alert-danger"
							ng-show="registerForm.password.$touched && registerForm.password.$error.required">This is a
							required field
						</div>
						<div class="alert alert-danger"
							ng-show="registerForm.password.$error.minlength">Minimum
							length required is 6
						</div>
						<div class="alert alert-danger"
							ng-show="registerForm.$error.password">This field is
							invalid
						</div>
				</div>

				<!-- Form submit button -->
				<div class="form-actions floatRight">
					<input class="btn btn-primary" type="submit"
						value="{{!user.id ? 'Register' : 'Update' }}"
						ng-disabled="registerForm.$invalid" 
					/>
				</div>
				</form>
			</div>
		</div>

		<!-- List of users -->
		<div class="container panel panel-default mt-5">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">List of Users </span>
			</div>
			<div class="tablecontainer">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Password</th>
							<th width="20%"></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="user in users">
							<td>{{user.firstName}}</td>
							<td>{{user.lastName}}</td>
							<td>{{user.email}}</td>
							<td>{{user.password}}</td>
							<td>
								<button type="button" ng-click="edit(user.id)"
									class="btn btn-success custom-width">Edit</button>
								<button type="button" ng-click="remove(user.id)"
									class="btn btn-danger custom-width">Remove</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</main>

	<footer>
		<div class="container">
			<p>©DevelopersCorner 2023 All rights reserved</p>
		</div>
	</footer>

</body>
</html>