<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit contact</title>
<s:url var="url_css"
	value="${request.contextPath}/resources/css/style.css" />
<link href="${url_css}" rel="stylesheet" type="text/css" />
<s:url var="url_jqlib"
	value="${request.contextPath}/resources/js/jquery-3.2.1.min.js" />
<script src="${url_jqlib}"></script>
</head>

</head>
<%-- <s:url var="url_bg"
	value="${pageContext.request.contextPath}/resources/images/bg.jpg" /> --%>
<s:url var="url_bg"
	value="${request.contextPath}/resources/images/bg.jpg" />
<body background="${url_bg}">
    <div align="center">
        <h1>New/Edit Employee</h1>
        <form:form action="saveEmployee" method="post" modelAttribute="employee">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>DOB:</td>
                <td><form:input path="dob" /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><form:input path="address" /></td>
            </tr>
            <tr>
                <td>Telephone:</td>
                <td><form:input path="telephone" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>