<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/Hid/allDevice">&larr; devices</a>
	<form:form action="/Hid/${deviceId}/connections/add"
		commandName="connection" method="POST">
City: <form:input path="city" />
		<br />
County: <form:input path="country" />
		<br />
		<input type="submit" value="add" />
	</form:form>

	<core:forEach items="${connectionList}" var="connection">
Id: ${connection.id}<br />
City: ${connection.city}<br />
County: ${connection.country}<a
			href="/Hid/${deviceId}/connections/delete?id=${connection.id}">X</a>
		<br />
		<hr />
	</core:forEach>
<h1> Бугага. All connections all devices.</h1>

	<core:forEach items="${connectionAll}" var="connection">
Id: ${connection.id}<br />
City: ${connection.city}<br />
County: ${connection.country}<a
			href="/Hid/${deviceId}/connections/delete?id=${connection.id}">X</a>
		<br />
		<hr />
	</core:forEach>
</body>
</html>