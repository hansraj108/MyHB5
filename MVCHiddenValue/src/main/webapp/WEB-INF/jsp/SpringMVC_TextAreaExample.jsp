<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.error {
 color: red;
 font-weight: bolder;
}
 
.commonerrorblock {
 color: #000;
 background-color: #ffEEEE;
 border: 3px solid #ff0000;
 
}
</style>
</head>
<body>
 <form:form method="post" action="processTextAreaForm" commandName="ta">
 <form:errors path="*" element="div" cssClass="commonerrorblock"/>
 <table>
 <tr>
 <td>Address</td>
 <td>
 <form:textarea path="address" row="5" col="40"></form:textarea>
 </td>
 <td>
 <form:errors path="address" cssClass="error"/>
 </td>
 </tr>
 <tr>
 <td></td><td><input type="submit"></td>
 </tr>
 </table>
 </form:form>
</body>
</html>