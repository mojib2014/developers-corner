
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html><html>
<head>
	<link href="/static/css/nav.css" rel="stylesheet">
	<title>Developers Corner | Get Unstuck</title>
</head>
<body>
	<header>
		<nav>
			<ul>
				<li><a href="/">Home</a></li>
				<li><a href="/login">Login</a></li>
				<li><a href="/chat">Chat</a></li>
				<li><a href="/register">Register</a></li>
			</ul>
		</nav>
	</header>
	<h1>Welcome to Developers Corner</h1>
	<p>${message }
	  <form action="greet">
        <input type="submit" value="Press to greet">
    </form>
</body>
</html>
