<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard - Contact App</title>
<s:url var="url_css" value="/static/css/style.css"></s:url>
<link href="url_css" rel="stylsheet" type="text/css"/>
</head>
<s:url var="url_bg" value="/static/images/bg.jpg"></s:url>
<body background="${url_bg}">
	<table border="1" width="80%" align="center">
		<tr>
			<td height="80px">
			<jsp:include page="include/header.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td height="25px">
			<jsp:include page="include/menu.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td height="350px" valign="top">Admin Dashboard</td>
		</tr>
		<tr>
			<td height="25px">
			<jsp:include page="include/footer.jsp"></jsp:include>
			</td>
		</tr>
	
	</table>
</body>
</html>