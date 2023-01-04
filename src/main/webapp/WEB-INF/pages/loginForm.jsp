<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
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
			<div class="input-group mb-3">
				<span class="input-group-text" id="basic-addon1">@</span> <input
					type="email" name="username" class="form-control"
					placeholder="email@example.com" aria-label="Username"
					aria-describedby="basic-addon1" required>
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text" id="basic-addon1"><svg
						xmlns="http://www.w3.org/2000/svg" width="16" height="16"
						fill="currentColor" class="bi bi-lock" viewBox="0 0 16 16">
  <path
							d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2zM5 8h6a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1V9a1 1 0 0 1 1-1z" />
</svg></span> <input type="password" name="password" class="form-control"
					placeholder="m@2#ac%" aria-label="Password"
					aria-describedby="basic-addon1" required>
			</div>
			<input class="btn btn-primary" type="submit" value="Login" />
		</form>
	</main>

	<footer>
		<div class="container">
			<p>All rights reserved</p>
		</div>
	</footer>
</body>
</html>