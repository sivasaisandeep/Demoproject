<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registered Employees</title>
</head>
<body>
	<table align="center">
		<tr>
			<td colspan="3"><h1>Registered Employees</h1></td>
		</tr>
		<tr>
			<td><h4>First Name</h4></td>
			<td><h4>Last Name</h4></td>
			<td><h4>Address</h4></td>
			<td><h4>Phone</h4></td>
			<td><h4>Email</h4></td>
		</tr>
		<c:forEach items="${eList}" var="e">
			<tr>
				<td>${e.firstname}</td>
				<td>${e.lastname}</td>
				<td>${e.address}</td>
				<td>${e.phone}</td>
				<td>${e.email}</td>
			</tr>
		</c:forEach>
		<tr>
			<td></td>
			<td><a href="register">Register</a></td>
		</tr>
		<tr></tr>
		<tr>
			<td></td>
			<td><a href="home">Home</a></td>
		</tr>
	</table>
</body>
</html>