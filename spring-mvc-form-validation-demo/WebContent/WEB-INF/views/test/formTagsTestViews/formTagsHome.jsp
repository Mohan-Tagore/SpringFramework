<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<spring:url value="/resources/test-main.css" var="testMainCSS"></spring:url>
<link href="${testMainCSS}" rel="stylesheet">
<title>Test Bed</title>
</head>
<body>
	<div align="center">
		<h1>Welcome to the Form Tags Test Bed</h1>
		<hr>
		<h3>Register your organization with us!!</h3>
		<form:form action="registerOrg" modelAttribute="orgRegistration">
			<table>
				<tr>
					<td><form:label path="orgName">Name of the Organization</form:label></td>
					<td><form:input path="orgName"
							placeholder="Enter Organization Name"></form:input></td>
				</tr>

				<tr>
					<td><form:label path="country">Country</form:label></td>
					<td><form:select path="country">
							<form:option value="None">-----SELECT-----</form:option>
							<form:option value="Australia">Australia</form:option>
							<form:option value="India">India</form:option>
							<form:option value="US">US</form:option>
							<form:option value="Sweden">Sweden</form:option>
							<form:option value="Egypt">Egypt</form:option>
						</form:select></td>
				</tr>

				<tr>
					<td><form:label path="turnOver">Turnover</form:label></td>
					<td><form:select path="turnOver" items="${turnOverList}"></form:select></td>
				</tr>

				<tr>
					<td><form:label path="type">Type</form:label></td>
					<td><form:select path="type">
							<form:option value="NONE">-----SELECT-----</form:option>
							<form:options items="${typeList}" />
						</form:select></td>
				</tr>

				<tr>
					<td><form:label path="serviceLength">Service Length</form:label></td>
					<td><form:select path="serviceLength" items="${serviceLengthList}"></form:select></td>
				</tr>

				<tr>
					<td><form:label path="registeredPreviously">Registered Previously</form:label></td>
					<td><form:checkbox path="registeredPreviously"	items="${registeredPreviouslyList}"></form:checkbox></td>
				</tr>

				<tr>
					<td><form:label path="like">Like our Website?</form:label></td>
					<td><form:checkbox path="like" value="yes"></form:checkbox>Like</td>
				</tr>

				<tr>
					<td><form:label path="optionalServices">Optional Services Subscriptions</form:label></td>
					<td>
						<form:checkbox path="optionalServices" value="emailService" />${subscriptionList.emailService} 
						<form:checkbox path="optionalServices" value="promotionalService" />${subscriptionList.promotionalService}
						<form:checkbox path="optionalServices" value="newsLetterService" />${subscriptionList.newsLetterService}
					</td>
				</tr>

				<tr>
					<td><form:label path="premiumServices">Premium Services</form:label></td>
					<td><form:checkboxes path="premiumServices"	items="${premiumServiceList}" /></td>
				</tr>

				<tr>
					<td><form:label path="overseasOperations">Overseas Operations</form:label></td>
					<td>
						<form:radiobutton path="overseasOperations" value="Yes" />Yes
						<form:radiobutton path="overseasOperations" value="No" />No
					</td>
				</tr>

				<tr>
					<td><form:label path="employeeStrength">Workforce Size</form:label></td>
					<td><form:radiobuttons path="employeeStrength"	items="${employeeStrengthList}" /></td>
				</tr>

				<tr>
					<td align="center"><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>