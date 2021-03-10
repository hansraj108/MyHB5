<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Management</title>
<link rel="stylesheet"
href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>

<body>
<nav class="navbar navbar-default">
<div class="container-fluid">
<div class="navbar-header">
<a class="navbar-brand" href="/MVC20">Employee Details</a>
</div>
<ul class="nav navbar-nav">
<li class="active"><a href="<c:url value="empform" />">Add Employee</a></li>
<li><a href="<c:url value="viewemp" />">View Employees</a></li>

</ul>
</div>
</nav>

	<table border="2" width="70%" cellpadding="2">
	<div class="form-group">
	<tr><th>Id</th><th>Name</th><th>Salary</th><th>Designation</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="emp" items="${list}"> 
    <tr>
    <div class="container">

  <div class="row">
    <div class="col-md-4">
      <td>${emp.id}</td>
    </div>
  </div>
  <div class="row">
    <div class="col-md-4">
      <td>${emp.name}</td>
    </div>
  </div>
  <div class="row">
    <div class="col-md-4">
      <td>${emp.salary}</td>
    </div>
  </div>
  <div class="row">
    <div class="col-md-4">
      <td>${emp.designation}</td>
    </div>
  </div>
   <div class="row">
    <div class="col-md-4">
      <td><a href="editemp/${emp.id}">Edit</a></td>
    </div>
  </div>
   <div class="row">
    <div class="col-md-4">
      <td><a href="deleteemp/${emp.id}">Delete</a></td>
    </div>
  </div>
  </div>
  </tr>
  <%--   <td>${emp.name}</td>
    <td>${emp.salary}</td>
    <td>${emp.designation}</td>
    <td><a href="editemp/${emp.id}">Edit</a></td>
    <td><a href="deleteemp/${emp.id}">Delete</a></td>
    </tr> --%>
    </c:forEach>
    </div>
    </table>
    <br/>
    <a href="empform">Add New Employee</a>
    
    
   
    
</body>
</html>