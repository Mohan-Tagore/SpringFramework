<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<spring:url value="/resources/test-main.css" var="testMainCSS"></spring:url>
<link href="${testMainCSS}" rel="stylesheet">
<title>Form Tags Test Results</title>
</head>
<body>
	<h1>Congratulations!! You have registered the organization</h1>
	<h2>Details below......</h2>
	<hr />
	<div style="margin-left: 600px; width: auto">
		<h3>
			Organization Name:<b>${orgreg.orgName}</b>
		</h3>
		<h3>
			Country:<b>${orgreg.country}</b>
		</h3>

		<h3>
			Turnover:
			<c:forEach var="entry" items="${turnOverList}">
				<c:if test="${orgreg.turnOver eq entry.key}">
					<b>${entry.value}</b>
				</c:if>
			</c:forEach>
		</h3>

		<h3>
			Type:
			<c:forEach var="entry" items="${typeList}">
				<c:if test="${orgreg.type eq entry.key}">
					<b>${entry.value}</b>
				</c:if>
			</c:forEach>
		</h3>

		<h3>
			Organization Age:
			<c:forEach var="entry" items="${serviceLengthList}">
				<c:if test="${orgreg.serviceLength eq entry.key}">
					<b>${entry.value}</b>
				</c:if>
			</c:forEach>
		</h3>
		
		<h3>
			Registered Previously:
			<c:forEach var="entry" items="${registeredPreviouslyList}">
				<c:if test="${orgreg.registeredPreviously eq entry.key}">
					<b>${entry.value}</b>
				</c:if>
			</c:forEach>
		</h3>
		
		<h3>Like our Website:
			<c:choose>
				<c:when test="${orgreg.like eq 'yes'}">
					<b>Like</b>
				</c:when>
				<c:otherwise>
					<b>Do not like</b>
				</c:otherwise>
			</c:choose>
		</h3>
		
		<h3>
			Optional Services signed up for:
			<c:forEach var="entry1" items="${subscriptionList}">
				<c:forEach var="entry2" items="${orgreg.optionalServices}">
					<c:if test="${entry2 eq entry1.key}" >
						<c:set var="optService" scope="request" value="${optService}${entry1.value}, "/>
					</c:if>
				</c:forEach>
			</c:forEach>
			<b>${optService.substring(0, optService.length()-2)}</b>
		</h3>
		
		<h3>
			Premium Services signed up for:
			<c:forEach var="entry1" items="${premiumServiceList}">
				<c:forEach var="entry2" items="${orgreg.premiumServices}">
					<c:if test="${entry2 eq entry1.key}" >
						<c:set var="premiumService" scope="request" value="${premiumService}${entry1.value}, "/>
					</c:if>
				</c:forEach>
			</c:forEach>
			<b>${premiumService.substring(0, premiumService.length()-2)}</b>
		</h3>
		
		<h3>Has Overseas Operations: <b>${orgreg.overseasOperations}</b></h3>
		
		<h3>
			Workforce size:
			<c:forEach var="entry" items="${employeeStrengthList}">
				<c:if test="${orgreg.employeeStrength eq entry.key}">
					<b>${entry.value}</b>
				</c:if>
			</c:forEach>
		</h3>
		
	</div>
</body>
</html>