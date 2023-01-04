<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/static/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="/static/css/styles.css" rel="stylesheet" type="text/css">
<title>Developers Corner | Register Page</title>
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
		<form action="register" method="post">
			<div class="input-group mb-3">
			  <span class="input-group-text" id="basic-addon1"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
  <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z"/>
</svg></span>
			  <input type="text" name="firstName" class="form-control" placeholder="John" aria-label="First Name" aria-describedby="basic-addon1" required>
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text" id="basic-addon1">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
  <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z"/>
</svg>
				</span>
				  <input type="text" name="lastName" class="form-control" placeholder="Doe" aria-label="Last Name" aria-describedby="basic-addon1" required>
			</div>
			<div class="input-group mb-3">
			  <span class="input-group-text" id="basic-addon1">@</span>
			  <input type="email" name="username" class="form-control" placeholder="email@example.com" aria-label="Username" aria-describedby="basic-addon1" required>
			</div>
			<div class="input-group mb-3">
			  <span class="input-group-text" id="basic-addon1"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-lock" viewBox="0 0 16 16">
  <path d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2zM5 8h6a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1V9a1 1 0 0 1 1-1z"/>
</svg></span>
			  <input type="password" name="password" class="form-control" placeholder="m@2#ac%" aria-label="Password" aria-describedby="basic-addon1" required>
			</div>
			<input class="btn btn-primary" type="submit" value="Register"/>
		</form>
	</main>
	
	<footer>
		<div class="container">
			<p>All rights reserved</p>
		</div>
	</footer>
</body>
</html>