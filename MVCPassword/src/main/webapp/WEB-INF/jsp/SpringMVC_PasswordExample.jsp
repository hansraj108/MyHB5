<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri ="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.error {
 color: #ff0000;
}
 
.commonerrorblock {
 color: #000;
 background-color: #ffEEEE;
 border: 3px solid #ff0000;
 
}
</style>
</head>
<body>
<form:form action="check" method="post" commandName="rb">
 <form:errors path="*" element="div" cssClass="commonerrorblock"/>
 <table>
 <tr>
 <td>Password</td>
 <td><form:password path="password" /></td>
 <td><form:errors path="password" cssClass="error"/></td>
 </tr>
 <tr>
 <td>ConfirmPassword</td>
 <td><form:password path="confirmPassword" showPassword="true"/></td>
 <td><form:errors path="confirmPassword" cssClass="error"/></td>
 </tr>
 <tr>
 <td></td><td><input type="submit"></td><td></td>
 </tr>
 </table>
 </form:form>
</body>
</html>