<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MVC Test Home</title>
<style>
	h2 {
		color: #08298A;
		text-align: center
	}
</style>

</head>
<body>
	<h2>MVC Test Home</h2>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<div style="text-align: center">
		<a href="${contextPath}/requestMappingAndParamDemo/home" style="font-size: 20px">
			Click here to go to the test bed for @RequestMapping and @RequestParam <br/>
		</a>
	</div>	
</body>
</html>