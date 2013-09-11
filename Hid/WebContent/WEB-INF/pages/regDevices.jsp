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
	<form:form action="/Hid/${deviceId}/regDevices/add"
		commandName="reDevices" method="POST">
Date Registration: <input type="date" path="registrationDate" />
		<br />
End License Date: <input type="date" path="endLicenseDate" />
		<br />
		<input type="submit" value="add" />
	</form:form>

	<core:forEach items="${regDeviceList}" var="regDevices">
Id: ${regDevice.id}<br />
Date registration: ${regDevice.registrationDate}<br />
End License Date: ${regDevice.registrationDate}<a
			href="/Hid/${deviceId}/regDevices/delete?id=${regDevice.id}">X</a>
		<br />
		<hr />
	</core:forEach>
</body>
</html>