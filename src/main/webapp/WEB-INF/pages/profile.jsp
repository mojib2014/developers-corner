<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.js"
	type="text/javascript"></script>
<script src="/static/js/app.module.js" type="text/javascript"></script>
<script src="/static/js/controller/profile.controller.js" type="text/javascript" defer></script>
<script src="/static/js/service/profile.service.js" type="text/javascript" defer></script>
<script src="/static/js/activeNavLinks.js" type="text/javascript" defer></script>
<link href="/static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="/static/css/styles.css" rel="stylesheet" type="text/css">
<title>Developers Corner | Profile </title>
</head>
<body data-ng-app="developersCorner" ng-controller="ProfileController">
	<header>
		<div class="container">
			<nav>
				<a class="logo" href="/">Developers Corner</a>
				<ul>
					<li><a href="/">Home</a></li>
					<li ng-show="!isLoggedIn"><a href="/login">Login</a></li>
					<li ng-show="isLoggedIn"><a href="#">Logout</a></li>
					<li><a href="/questions">Questions</a></li>
					<li><a href="/register">Register</a></li>
					<li><a href="/profile">Profile</a></li>
				</ul>
			</nav>
		</div>
	</header>

	<main class="main">
		<div class="container panel panel-default mt-5">
			<h1>{{user.lastName}} Profile</h1>
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
						<td>{{user.createdAt}}</td>
						<td>
							<button type="button" ng-click="openModal(question)"
								class="btn btn-success custom-width">Edit</button>
							<button type="button" ng-click="deleteAccount(user)"
								class="btn btn-danger custom-width">Remove</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
</body>
</html>