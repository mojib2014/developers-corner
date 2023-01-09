<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Oops something went wrong</h1>
	<c:forEach items="${errors}" var="error">
		<code>
			${ error.defaultMessage }
		</code>
	</c:forEach>
	${errors}
</body>
</html>