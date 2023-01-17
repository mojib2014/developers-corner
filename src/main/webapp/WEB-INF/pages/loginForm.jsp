<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="/static/css/styles.css" rel="stylesheet" type="text/css">
<script src="/static/js/activeNavLinks.js" type="text/javascript" defer></script>
<title>Developers Corner | Login Page</title>
</head>
<body>
	<header>
		<div class="container">
			<nav>
				<a class="logo" href="/">Developers Corner</a>
				<ul>
						<li><a href="/">Home</a></li>
					<li style="display: ${!user.token ? "block" : "none"}"><a href="/login">Login</a></li>
					<li><a id="logout" href="#">Logout</a></li>
					<li><a href="/questions">Questions</a></li>
					<li><a href="/register">Register</a></li>
					<li><a href="/profile">Profile</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<main class="container">
	<c:forEach items="${errors}" var="error">
		<code class="error mb-3">
			${ error }
		</code>
	</c:forEach>
		<form:form action="login" method="post"
			modelAttribute="loginForm">
			<div class="panel container-xsm m-auto">
			<div class="input-group mb-3">
				<span class="input-group-text" id="basic-addon1">@</span>
				<form:input path="email" type="email" name="email"
					class="form-control" placeholder="email@example.com"
					aria-label="Email" aria-describedby="basic-addon1" />
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text" id="basic-addon1"><svg
						xmlns="http://www.w3.org/2000/svg" width="16" height="16"
						fill="currentColor" class="bi bi-lock" viewBox="0 0 16 16">
  <path
							d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2zM5 8h6a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1V9a1 1 0 0 1 1-1z" />
</svg></span>
				<form:input path="password" type="password" name="password"
					class="form-control" placeholder="m@2#ac%" aria-label="Password"
					aria-describedby="basic-addon1" />
			</div>
			<input class="btn btn-primary" type="submit" value="Login" />
			</div>
		</form:form>
		<h1 id="token" style="display: none;">${user.token}</h1>
	</main>

	<footer>
		<div class="container">
			<p>©DevelopersCorner 2023 All rights reserved</p>
		</div>
	</footer>
	
	<script>
		const tokenElement = document.querySelector("#token");
		const logoutAnchor = document.querySelector("#logout");
		window.localStorage.setItem('token', JSON.stringify(tokenElement.innerText));
		
		logoutAnchor.addEventListener('click', () => {
			localStorage.removeItem('token');
		});
		
	</script>
</body>
</html>