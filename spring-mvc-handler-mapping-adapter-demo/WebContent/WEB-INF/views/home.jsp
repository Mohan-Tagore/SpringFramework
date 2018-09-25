<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Organization Home Page</title>
</head>
<body>

	<h1>Organization Home Page</h1>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
	<ul>
		<li><a href="${contextPath}/jstlsql"> List Organization using JSTL sql tags</a> <br/></li>
		<li><a href="${contextPath}/service"> List Organization using service</a> <br/></li>
	</ul>
</body>
</html>