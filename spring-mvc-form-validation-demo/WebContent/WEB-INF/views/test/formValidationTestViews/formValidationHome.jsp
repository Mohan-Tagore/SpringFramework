<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<html>
<head>
	<spring:url value="/resources/test-main.css" var="testMainCSS" />
	<link href="${testMainCSS}" rel="stylesheet" />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Test bed</title></head>
<body>
	<div align="center">
		<h1 class="ch1">Welcome to Form Validation Test Bed</h1>
		<hr/>
		<h3>Please register yourself as your organization representative</h3>
		<form:form action="registerOrgRep" modelAttribute="orgrep">
			<table>
				<tr>
					<td><form:label path="firstName" cssClass="clabel">First Name</form:label></td>
					<td><form:input path="firstName" placeholder="Enter First Name" cssClass="cinput"/></td>
					<td><form:errors path="firstName" cssClass="cb"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="lastName" cssClass="clabel">Last Name</form:label></td>
					<td><form:input path="lastName" placeholder="Enter SurName" cssClass="cinput"/></td>
					<td><form:errors path="lastName" cssClass="cb"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="age" cssClass="clabel">Age</form:label></td>
					<td><form:input path="age" placeholder="Enter Age" cssClass="cinput"/></td>
					<td><form:errors path="age" cssClass="cb"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="email" cssClass="clabel">Email</form:label></td>
					<td><form:input path="email" placeholder="Enter email address" cssClass="cinput"/></td>
					<td><form:errors path="email" cssClass="cb"></form:errors>
						<spring:hasBindErrors name="orgrep">
							<c:forEach var="globalError" items="${errors.globalErrors}">
								<c:if test="${fn:contains(globalError, 'Email')}">
									<c:out value="${globalError.defaultMessage}"></c:out>
								</c:if>
							</c:forEach>
						</spring:hasBindErrors>
					</td>
				</tr>
				<tr>
					<td><form:label path="verifyEmail" cssClass="clabel">Verify Email</form:label></td>
					<td><form:input path="verifyEmail" placeholder="Confirm email address" cssClass="cinput"/></td>
					<td><form:errors path="verifyEmail" cssClass="cb"></form:errors>
				</td>
				</tr>
				<tr>
					<td><form:label path="password" cssClass="clabel">Password</form:label></td>
					<td><form:password path="password" placeholder="Enter password" cssClass="cinput"/></td>
					<td><form:errors path="password" cssClass="cb"></form:errors>
						<spring:hasBindErrors name="orgrep">
							<c:forEach var="globalError" items="${errors.globalErrors}">
								<c:if test="${fn:contains(globalError, 'Password')}">
									<c:out value="${globalError.defaultMessage}"></c:out>
								</c:if>
							</c:forEach>
						</spring:hasBindErrors>
					</td>
				</tr>
				<tr>
					<td><form:label path="verifyPassword" cssClass="clabel">Verify Password</form:label></td>
					<td><form:password path="verifyPassword" placeholder="Confirm password" cssClass="cinput"/></td>
					<td><form:errors path="verifyPassword" cssClass="cb"></form:errors>
				</td>
				</tr>
				<tr>
					<td><form:label path="zipCode" cssClass="clabel">ZipCode</form:label></td>
					<td><form:input path="zipCode" placeholder="Enter Zip Code" cssClass="cinput"/></td>
					<td><form:errors path="zipCode" cssClass="cb"></form:errors></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="Submit" class="csubmit">
				</tr>
			</table>
			<hr/>
			<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
			<c:if test="${formerrors ne null}">
				<a href="${contextPath}/formValidationDemo/home" style="font-size: 17px">Click here to start a fresh form!</a>
			</c:if>
		</form:form>
	</div>

</body>
</html>