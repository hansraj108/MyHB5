<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page - My Contact App</title>
<s:url var="url_css" value="/static/css/style.css"/>
<link href="${url_css}" rel="stylesheet" type="text/css">
</head>
<s:url var="url_bg" value="/static/images/bg.jpg"/>
<body background="${url_bg}">
<h3 align="center">Login Page - My Contact App</h3>
<table border="1" width="80%" align="center">
	<tr height="80px">
		<td>
			<jsp:include page="include/header.jsp"></jsp:include>
		</td>
	</tr>
	<tr height="25px">
			<td>
			<jsp:include page="include/menu.jsp"></jsp:include>	
			</td>
	</tr>
	<tr height="350px" valign="top">
		<td>
			<h3>User Login</h3>
			<s:url var="url_login" value="/login1" ></s:url>
			<f:form action="${url_login}" modelAttribute="command" >
				<table border="1">
					<tr>
						<td>Username</td>
						<td><f:input path="loginName"/> </td>
					</tr>
					<tr>
						<td>Password</td>
						<td><f:password path="password"/> </td>
					</tr>
					<tr>
						<td colspan="2" align="right">
						<button>Login</button><br/>
						<a href="#">New User Registration</a>
						</td>
					</tr>
				</table>
			</f:form>
		</td>
	</tr>
	<tr height="25px" align="center">
		<td>
			<jsp:include page="include/footer.jsp"></jsp:include>
		</td>
	</tr>
</table>
</body>
</html>