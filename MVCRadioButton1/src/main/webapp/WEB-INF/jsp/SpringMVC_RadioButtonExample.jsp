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
 <form:form method="post" action="processRadioButtonForm" commandName="rb">
 <form:errors path="*" element="div" cssClass="commonerrorblock"/>
 <table>
 <tr>
 <td>Country</td>
 <td>
 <form:radiobutton path="country" value="India"/>India
 </td>
 
 <td>
 <form:radiobutton path="country" value="England"/>England
</td>

 <td>
 <form:radiobutton path="country" value="Australia"/>Australia
</td>

<td>
<form:radiobutton path="country" value="South Africa"/>South Africa
</td>

 </tr>
 <tr>
 <td></td><td><input type="submit"></td>
 </tr>
 <tr>
 <td>
 <form:errors path="country" cssClass="error"/>
 </td>
 </tr>
 </table>
 </form:form>
</body>
</html>