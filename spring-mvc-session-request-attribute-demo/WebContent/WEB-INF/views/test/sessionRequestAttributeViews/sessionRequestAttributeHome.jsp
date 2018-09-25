<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
  <%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<spring:url value="/resources/test-main.css" var="testMainCSS"></spring:url>
	<link href="${testMainCSS}" rel="stylesheet">
	<%-- <link href="<c:url value="/resource/test-main.css" />" rel="stylesheet"> --%>
</head>
<body>
	<div align="center">
		<h1>@SessionAttribute Test Bed</h1>
		<hr>
			<form:form action="visitor" modelAttribute="visitorstats">
				<table>
					<tr>
						<td><form:label path="currentVisitorName">Name</form:label></td>
						<td><form:input path="currentVisitorName"></form:input></td>
					</tr>
					
					<tr>
						<td><form:label path="currentVisitorEmail">Email</form:label></td>
						<td><form:input path="currentVisitorEmail"></form:input></td>
						<tr>
							<td align="center"><input type="submit" value="Submit"></td>
						</tr>
						
				</table>
			</form:form>
	</div>

</body>
</html>