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
<title>Employee Management Screen</title>
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
		<h1>Employee List</h1>
		<h3>
			<a href="newEmployee">New Employee</a>
		</h3>
		<table border="1">

			<th>Name</th>
			<th>DOB</th>
			<th>Email</th>
			<th>Address</th>
			<th>Telephone</th>
			<th>Action</th>

			<c:forEach var="employee" items="${listEmployee}">
				<tr>

					<td>${employee.name}</td>
					<td>${employee.dob}</td>
					<td>${employee.email}</td>
					<td>${employee.address}</td>
					<td>${employee.telephone}</td>
					<td><a href="editEmployee?id=${employee.id}">Edit</a> <a
						href="deleteEmployee?id=${employee.id}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>