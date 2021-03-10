<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-
//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error{ 
color: red;
font-family: consolas;
font-style: italic;
font-weight: bold;
font-size: large;
}
</style>
</head>
<body>
<br><br><br>
<h2 style="color: red;" align="center">Durga Software Solutions</h2>
<h3 style="color: red;" align="center">Student Registration Form</h3>
<form:form method="POST" action="reg" commandName="user">
<center>
<table>
<tr>
<td>User Name</td>
 <td><form:input path="uname"/></td>
<td><form:errors path="uname" cssClass="error"/>
</tr>
<tr>
<td>User Password</td>
<td><form:password path="upwd"/></td>
<td><form:errors path="upwd" cssClass="error"/>
</tr>
<tr>
<td>User Age</td>
<td><form:input path="uage"/></td>
<td><form:errors path="uage" cssClass="error"/>
</tr>
<tr>
 <td>User Email Id</td>
<td><form:input path="uemail"/></td>
 <td><form:errors path="uemail" cssClass="error"/>
</tr>
<tr>
 <td>User Mobile No</td>
 <td><form:input path="umobile"/></td>
<td><form:errors path="umobile" cssClass="error"/>
</tr>
<tr>
<td><input type="submit" value="Registration"/></td>
</tr> 
</table>
</center>
</form:form>
</body>
</html> 