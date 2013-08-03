<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Persons</title>
</head>
<body>

	<form:form action="" method="POST" commandName="person">
		<div>
			<label>First name: </label>
			<form:input path="firstName" />
		</div>
		<div>
			<label>Last name: </label>
			<form:input path="lastName" />
		</div>
		<div>
			<input type="submit" value="Add" />
		</div>
	</form:form>

	<spring:bind path="person.*">
		<core:if test="${not empty status.errorMessages}">
			<div class="error">
				<core:forEach items="${status.errorMessages}" var="error">
						${error}<br />
				</core:forEach>
			</div>
		</core:if>
	</spring:bind>
	
	<core:forEach items="${personsList}" var="person">
		${person.firstName}${person.lastName}
	</core:forEach>

</body>
</html>