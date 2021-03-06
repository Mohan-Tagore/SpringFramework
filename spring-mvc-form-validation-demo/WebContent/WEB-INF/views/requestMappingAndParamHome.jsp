<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>@RequestMapping and @RequestParam test bed</title>
<style>
input[type=text] {
	padding: 10px;
	margin: 10px;
	font-size: 20px
}

input[type=submit] {
	border: none;
	background-color: #4CAF50;
	color: white;
	padding: 16px;
	margin: 16px;
	cursor: pointer;
	font-size: 20px
}

h2 {
	color: #08298A;
	text-align: center
}
</style>
</head>
<body>
	<div align="left">
		<h2 align="center">Hello, welcome to @RequestMapping and
			@RequestParam Test bed</h2>
		<hr />

		<form action="test1">
			<h3>test 1: Testing @RequestParam without attributes</h3>
			<label id="organization-name">Organization Name</label> <input
				type="text" name="orgname" placeholder="Enter organization name"
				size="40" /> <input type="submit" value="Submit" />
		</form>

		<br />
		<br>

		<form action="test2">
			<h3>test 2: Testing @RequestMapping 'method' attribute</h3>
			<label id="organization-name">Organization Name</label> <input
				type="text" name="orgname" placeholder="Enter organization name"
				size="40" /> <input type="submit" value="Submit" />
		</form>

		<br />
		<br>

		<form action="test3">
			<h3>test 3: Testing @RequestMapping 'fall back' feature</h3>
			<input type="submit" value="Submit" />
		</form>


		<br />
		<br>

		<form action="test4">
			<h3>test 4: Testing @RequestParam defaultValue</h3>
			<label id="organization-name">Organization Name</label> <input
				type="text" name="orgname" placeholder="Enter organization name"
				size="40" /> <input type="submit" value="Submit" />
		</form>
		<br />
		<br>

		<form action="test5">
			<h3>test 5: Testing @RequestParam without value or name attributes</h3>
			<label id="organization-name">Organization Name</label> <input
				type="text" name="orgname" placeholder="Enter organization name"
				size="40" /> <input type="submit" value="Submit" />
		</form>

	</div>
</body>
</html>