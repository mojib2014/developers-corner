<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.js"
	type="text/javascript"></script>
	<script type="text/javascript"
	src="https://cdn.rawgit.com/auth0/angular-jwt/master/dist/angular-jwt.js"></script>
	<script src="/static/js/service/auth.service.js" defer
	type="text/javascript"></script>
<script src="/static/js/app.module.js" type="text/javascript"></script>
<script src="/static/js/controller/profile.controller.js"
	type="text/javascript" defer></script>
<script src="/static/js/service/profile.service.js"
	type="text/javascript" defer></script>
<script src="/static/js/service/user.service.js"
	type="text/javascript" defer></script>
<script src="/static/js/activeNavLinks.js" type="text/javascript" defer></script>
<link href="/static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="/static/css/styles.css" rel="stylesheet" type="text/css">
<title>Developers Corner | Profile</title>
</head>
<body data-ng-app="developersCorner" ng-controller="ProfileController">
	<header>
		<div class="container">
			<nav>
				<a class="logo" href="/">Developers Corner</a>
				<ul>
					<li><a href="/">Home</a></li>
					<li ng-show="!isLoggedIn"><a href="/login">Login</a></li>
					<li ng-show="isLoggedIn"><a href="#" ng-click="logout()">Logout</a></li>
					<li><a href="/questions">Questions</a></li>
					<li><a href="/register">Register</a></li>
					<li><a href="/profile">Profile</a></li>
				</ul>
			</nav>
		</div>
	</header>

	<main class="main">
		<div class="container panel panel-default mt-5">
			<h1 class="mb-4">{{user.lastName}}'s Profile</h1>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>CreatedAt</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>{{user.firstName}}</td>
						<td>{{user.lastName}}</td>
						<td>{{user.email}}</td>
						<td>{{user.createdAt.dayOfWeek}} {{user.createdAt.month}}
							{{user.createdAt.dayOfMonth}} {{user.createdAt.year}}</td>
						<td>
							<button type="button" ng-click="openModal(user)"
								class="btn btn-success custom-width">Edit</button>
							<button type="button" ng-click="deleteUserProfile(user.id)"
								class="btn btn-danger custom-width">Remove</button>
						</td>
					</tr>
				</tbody>
			</table>
			<div ng-show="showModal" class="modal-container" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Edit Question Form</h5>
						<button ng-click="closeModal()" type="button" class="close"
							data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form name="profileForm" ng-submit="editUserProfile(user)">
							<input type="hidden" ng-model="user.id" />
							<div class="input-group mb-3">
								<span class="input-group-text" id="firstName">First Name
								</span> <input type="text" name="firstName" ng-model="user.firstName"
									class="form-control" placeholder="John" aria-label="First Name"
									aria-describedby="First Name" required ng-minlength="5" />
							</div>
							<div class="alert alert-danger"
							ng-show="profileForm.firstName.$touched && profileForm.firstName.$error.required">
							This is a required field</div>
							<div class="alert alert-danger"
							ng-show="profileForm.firstName.$error.minlength">Minimum
							length required is 5</div>
							
							
							<div class="input-group mb-3">
								<span class="input-group-text" id="lastName">Last Name
								</span> <input type="text" name="lastName" ng-model="user.lastName"
									class="form-control" placeholder="Doe" aria-label="Last Name"
									aria-describedby="Last Name" required ng-minlength="5" />
							</div>
							<!-- Last Name errors -->
						<div class="alert alert-danger"
							ng-show="profileForm.lastName.$touched && profileForm.lastName.$error.required">
							This is a required field</div>
						<div class="alert alert-danger"
							ng-show="profileForm.lastName.$error.minlength">Minimum
							length required is 5</div>
							
							
							<div class="input-group mb-3">
								<span class="input-group-text" id="nickName">Nick Name
								</span> <input type="text" name="nickName" ng-model="user.nickName"
									class="form-control" placeholder="John (Optional)" aria-label="Nick Name"
									aria-describedby="Nick Name" />
							</div>
							
							<div class="input-group mb-3">
								<span class="input-group-text" id="email">Email
								</span> <input type="email" name="email" ng-model="user.email"
									class="form-control" placeholder="john.doe@domain.com" aria-label="Eamil"
									aria-describedby="Email" required />
							</div>
							<!-- Email errors  -->
						<div class="alert alert-danger"
							ng-show="profileForm.email.$touched && profileForm.email.$error.required">
							This is a required field</div>
						<div class="alert alert-danger"
							ng-show="profileForm.$error.email">This field is invalid</div>
							
							<div class="form-actions floatRight">
								<input class="btn btn-primary" type="submit" value="Go" />
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal" ng-click="closeModal()">Close</button>
					</div>
				</div>
			</div>
		</div>
</body>
</html>