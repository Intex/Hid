<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addAdmin</title>
</head>
<body>
	<form:form action="" commandName="admin" method="POST">
Login: <form:input path="login" />
		<br />
Password: <form:password path="password" />
		<br />
Confirm: <form:password path="confirmPassword" />
		<br />
		<input type="submit" value="add" />
	</form:form>

	<spring:bind path="admin.*">
		<core:if test="${not empty status.errorMessages}">
			<div class="error">
				<core:forEach items="${status.errorMessages}" var="error">
						${error}<br />
				</core:forEach>
			</div>
		</core:if>
	</spring:bind>

	<core:forEach items="${adminList}" var="admin">
		${admin.login}<br />
	</core:forEach>
</body>
</html>