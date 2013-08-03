<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Coding.ru</title>
</head>
<body>
	<div id="header">Coding.ru</div>
	<div id="wrapper">
		<div id="menu">
			<tiles:putAttribute name="menu"/>
		</div>
		<div id="content">
			<tiles:putAttribute name="content"/>
		</div>
	</div>
	<div id="footer">coding &copy;</div>
</body>
</html>