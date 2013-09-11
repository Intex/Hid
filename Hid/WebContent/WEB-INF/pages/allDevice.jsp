<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="" commandName="device" method="POST">
	Vendor id: <form:input path="vendorId" />
		<br />
	Product id: <form:input path="productId" />
		<br />
		<input type="submit" value="add" />
</form:form>

<spring:bind path="device.*">
		<core:if test="${not empty status.errorMessages}">
			<div class="error">
				<core:forEach items="${status.errorMessages}" var="error">
						${error}<br />
				</core:forEach>
			</div>
		</core:if>
	</spring:bind>

<core:forEach items="${deviceList}" var="device">
		id: ${device.id}<br />
		vendorId: ${device.vendorId}<br />
		productId: ${device.productId}<a href="/Hid/deleteDevice?id=${device.id}">X</a><br />
		<a href="/Hid/${device.id}/connections">connections</a><br />
		<a href="/Hid/${device.id}/regDevices">RegDevice</a>
		<hr />
</core:forEach>
</body>
</html>