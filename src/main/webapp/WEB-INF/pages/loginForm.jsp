<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/static/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="/static/css/styles.css" rel="stylesheet" type="text/css">
<title>Developers Corner | Login Page</title>
</head>
<body>
	<header>
	    <div class="container">
			<nav>
				<ul>
					<li><a href="/">Home</a></li>
					<li><a href="/login">Login</a></li>
					<li><a href="/chat">Chat</a></li>
					<li><a href="/register">Register</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<main class="container">
		<form action="login" method="post">
			<label for="username">Username: </label> 
			<input name="username" id="username" type="email" placeholder="email@example.com" /> 
			<label for="password">Password: </label> 
			<input name="password" id="password" type="password" placeholder="m@2#ac%" />
			<input type="submit" />
		</form>
	</main>
	
	<footer>
		<div class="container">
			<p>All rights reserved</p>
		</div>
	</footer>
</body>
</html>