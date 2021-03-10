<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <center><h1>Registration Successful</h1></center>
 <table align="center" border="1">
 <tr>
 <td>FirstName</td>
 <td>${rb.firstName}</td>
 </tr>
 <tr>
 <td>LastName</td>
 <td>${rb.lastName}</td>
 </tr>
 <tr>
 <td>Email</td>
 <td>${rb.email}</td>
 </tr>
 <tr>
 <td>Profession</td>
 <td>${rb.profession}</td>
 </tr>
 <tr>
 <td>Hobby</td>
 <td><c:forEach var="val" items="${rb.hobby}">
 <c:out value="${val}"></c:out>
 </c:forEach></td>
 </tr>
 </table>
 <a href="index.jsp">Back to home...</a>
</body>
</html>