
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="/static/css/styles.css" rel="stylesheet" type="text/css">
<script src="/static/js/activeNavLinks.js" type="text/javascript" defer></script>
<script src="/static/js/main.js" type="text/javascript" defer></script>
<title>Developers Corner | Get Unstuck</title>
</head>
<body>
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
	<main>
		<div class="container">
			<section>
				<h1>Welcome to Developers Corner</h1>
				<p>This is the banner area</p>
			</section>
			<article class="row alignt-items-center">
				<div class="chat-btn container mb-4">
					<button class="btn btn-primary chat-btn">Chat</button>
				</div>
				<aside class="col col-2 your-status aside-left shadow-lg p-3 bg-body rounded">
					<h2>Your Status</h2>
				</aside>
				<section class="col col-8 ask-question-form possible-solutions">
					<h2>Check In</h2>
					<form id="check-in-form">
						<div class="input-group mb-3">
							<span class="input-group-text" id="basic-addon1">User Name</span>
							<input type="text" name="username" class="form-control"
								placeholder="mojib2014" aria-label="Username"
								aria-describedby="basic-addon1" required />
						</div>
						<div class="mb-3">
							<input type="radio" id="student" name="role" value="student" class="button btn-sm btn-info student-btn" required />
							<label class="mr-3" for="student">I'm a Student</label>
							<input type="radio" id="mentor" name="role" value="mentor" class="button btn-sm btn-info mentor-btn" required />
							<label for="mentor">I'm a
								Mentor</label>
						</div>
						<div class="input-group mb-3">
							<span class="input-group-text" id="basic-addon1">Tags</span> <input
								type="text" name="tags" class="form-control" placeholder="Java"
								aria-label="Tags" aria-describedby="basic-addon1" required />
						</div>
						<div class="input-group mb-3">
							<textarea name="topic" class="form-control" rows="3"
								placeholder="Enter a topic you wanna search for" required></textarea>
						</div>
						<div class="form-actions floatRight">
							<input class="btn btn-primary" type="submit"
								value="Go"/>
						</div>
					</form>
				</section>
				<aside class="col col-2 users-online aside-right shadow-lg p-3 bg-body rounded">
					<h2>Users Online</h2>
				</aside>
			</article>
		</div>
	</main>
	<footer>
		<div class="container">
			<p>©DevelopersCorner 2023 All rights reserved</p>
		</div>
	</footer>
</body>
</html>
