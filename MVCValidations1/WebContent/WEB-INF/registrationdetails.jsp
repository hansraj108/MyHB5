<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-
//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Insert title here</title>
 </head>
 <body>
<br><br><br>
<h2 style="color: red;" align="center">Durga Software Solutions</h2>
<h3 style="color: red;" align="center">User Registration Details</h3>
<center>
<table border="1">
<tr>
 <td>User Name</td>
 <td>${user.uname}</td>
</tr>
<tr>
 <td>User Password</td>
 <td>${user.upwd}</td>
</tr>
<tr>
 <td>User Age</td>
 <td>${user.uage}</td>
</tr>
<tr>
<td>User Email Id</td>
<td>${user.uemail}</td>
</tr>
<tr>
<td>User Mobile No</td>
<td>${user.umobile}</td>
</tr> 
</table>
</center>
</body>
</html> 