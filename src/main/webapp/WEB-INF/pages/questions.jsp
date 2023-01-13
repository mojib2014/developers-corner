<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.js"
	type="text/javascript"></script>
<script type="text/javascript" src="/static/js/app.module.js"></script>
<script type="text/javascript"
	src="/static/js/controller/question.controller.js" defer></script>
<script type="text/javascript"
	src="/static/js/service/question.service.js" defer></script>
<script src="/static/js/activeNavLinks.js" type="text/javascript" defer></script>
<link href="/static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="/static/css/styles.css" rel="stylesheet" type="text/css">
<title>Developers Corner | Questions</title>
</head>
<body data-ng-app="developersCorner" class="ng-cloak">
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

	<main class="main" ng-controller="QuestionController">
		<div class="container panel panel-default mt-5">
			<h1 class="mb-4">Your questions</h1>
			<table class="table table-hover">
				<thead>  
					<tr>
						<th>Username</th>
						<th>Tags</th>
						<th>Question</th>
						<th>UserId</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="question in questions">
						<td>{{question.username}}</td>
						<td>{{question.tags}}</td>
						<td>{{question.question}}</td>
						<td>{{question.user.id}}</td>
						<td>
							<button type="button" ng-click="openModal(question)"
								class="btn btn-success custom-width">Edit</button>
							<button type="button" ng-click="deleteUserQuestion(question.id)"
								class="btn btn-danger custom-width">Remove</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div ng-show="showModal" class="modal-container" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Edit Question Form</h5>
				<button ng-click="closeModal()" type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form name="questionForm" ng-submit="editUserQuestion()">
						<input type="hidden" ng-model="question.id" />
						<div class="input-group mb-3">
							<span class="input-group-text" id="basic-addon1">User Name</span>
							<input type="text" name="username" ng-model="question.username" class="form-control"
								placeholder="mojib2014" aria-label="Username"
								aria-describedby="basic-addon1" required />
						</div>
						<div class="mb-3">
							<input type="radio" id="student" name="role" ng-model="question.role" value="student" class="button btn-sm btn-info student-btn" required />
							<label class="mr-3" for="student">I'm a Student</label>
							<input type="radio" id="mentor" name="role" ng-model="question.role" value="mentor" class="button btn-sm btn-info mentor-btn" required />
							<label for="mentor">I'm a
								Mentor</label>
						</div>
						<div class="input-group mb-3">
							<span class="input-group-text" id="basic-addon1">Tags</span> <input
								type="text" name="tags" ng-model="question.tags" class="form-control" placeholder="Java"
								aria-label="Tags" aria-describedby="basic-addon1" required />
						</div>
						<div class="input-group mb-3">
							<textarea name="topic" ng-model="question.question" class="form-control" rows="3"
								placeholder="Enter a topic you wanna search for" required></textarea>
						</div>
						<div class="form-actions floatRight">
							<input class="btn btn-primary" type="submit"
								value="Go"/>
						</div>
					</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal" ng-click="closeModal()">Close</button>
			</div>
		</div>
	</div>
	</main>
	
</body>
</html>