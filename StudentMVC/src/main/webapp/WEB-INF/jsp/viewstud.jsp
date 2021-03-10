<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Management</title>
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
<a class="navbar-brand" href="/StudentMVC">Student Details</a>
</div>
<ul class="nav navbar-nav">
<li class="active"><a href="<c:url value="studform" />">Add Student</a></li>
<li><a href="<c:url value="viewstud" />">View Students</a></li>

</ul>
</div>
</nav>

	<table border="2" width="70%" cellpadding="2">
	<div class="form-group">
	<tr><th>Id</th><th>Name</th><th>Mobile</th><th>Date of Birth</th><th>country</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="stud" items="${list}"> 
    <tr>
    <div class="container">

  <div class="row">
    <div class="col-md-4">
      <td>${stud.id}</td>
    </div>
  </div>
  <div class="row">
    <div class="col-md-4">
      <td>${stud.name}</td>
    </div>
  </div>
  <div class="row">
    <div class="col-md-4">
      <td>${stud.mobile}</td>
    </div>
  </div>
  <div class="row">
    <div class="col-md-4">
      <td>${stud.dob}</td>
    </div>
  </div>
  <div class="row">
    <div class="col-md-4">
      <td>${stud.country}</td>
    </div>
  </div>
   <div class="row">
    <div class="col-md-4">
      <td><a href="editstud/${stud.id}">Edit</a></td>
    </div>
  </div>
   <div class="row">
    <div class="col-md-4">
      <td><a href="deletestud/${stud.id}">Delete</a></td>
    </div>
  </div>
  </div>
  </tr>
  
    </c:forEach>
    </div>
    </table>
    <br/>
    <a href="studform">Add New Employee</a>
    
    
   
    
</body>
</html>