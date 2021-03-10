<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
 <form:form action="register" method="post" commandName="rb">
 <table>
 <tr><td>First Name</td><td><form:input path="firstName"/></td></tr>
 <tr><td>Last Name</td><td><form:input path="lastName"/></td></tr>
 <tr><td>Email</td><td><form:input path="email"/></td></tr>
 <tr><td>Profession</td><td><form:select path="profession" items="${professionList}"></form:select></td><td></td></tr>
 <tr><td>Hobby</td><td><form:checkboxes items="${hobbyList}" path="hobby"/></td></tr>
 <tr><td></td><td><input type="submit" value="Register"></td></tr>
 </table>
 </form:form>
 </body>
</html>