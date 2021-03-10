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
				<a class="navbar-brand" href="#">Add New Employee</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="<c:url value="empform" />">Add
						Employee</a></li>
				<li><a href="<c:url value="viewemp" />">View Employees</a></li>

			</ul>
		</div>
	</nav>
	<form:form method="post" action="save">
		<table>
			<tr>
				<td><label class="control-label col-sm-4" for="name">Name:</label>
					<div class="col-sm-8">
						<form:input path="name" type="text" class="form-control"
							placeholder="Name" />
					</div>
				</td>
			</tr>
			<tr>
				<td><label class="control-label col-sm-4" for="salary">Salary:</label>
					<div class="col-sm-8">
						<form:input path="salary" type="text" class="form-control"
							placeholder="Salary" />
					</div>
				</td>
			</tr>
			<tr>
				<td><label class="control-label col-sm-4" for="designation">Designation:</label>
					<div class="col-sm-8">
						<form:input path="designation" type="text" class="form-control"
							placeholder="Designation" />
					</div>
				</td>
			</tr>
			<tr>
				<td align="right"><div class="form-group"> 
<div class="col-sm-offset-2 col-sm-10">
<button type="submit" class="btn btn-default">Submit</button>
</div>
</div>
</td>
				
			</tr>
		</table>
		<div class="form-group">
		</div>
	</form:form>


</body>
</html>

