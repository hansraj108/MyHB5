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
				<a class="navbar-brand" href="#">Add New Student</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="<c:url value="studform" />">Add
						Student</a></li>
				<li><a href="<c:url value="viewstud" />">View Student</a></li>

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
				<td><label class="control-label col-sm-4" for="mobile">Mobile:</label>
					<div class="col-sm-8">
						<form:input path="mobile" type="text" class="form-control"
							placeholder="Mobile" />
					</div>
				</td>
			</tr>
			<tr>
				<td><label class="control-label col-sm-4" for="dob">Date of Birth:</label>
					<div class="col-sm-8">
						<form:input path="dob"  class="form-control" placeholder="dd/mm/yyyy" />
					<%-- <form:input path="dob" type= "date" class="form-control"
							placeholder="dob" /> --%>
					</div>
				</td>
			</tr>
			
			<tr>
				<td><label class="control-label col-sm-4" for="country">Country:</label>
					<div class="col-sm-8">
					<form:select path="country">  
        <form:option value="India" label="India"/>  
        <form:option value="USA" label="USA"/>  
        <form:option value="Canada" label="Canada"/>  
        <form:option value="Australia" label="Australia"/>  
        </form:select>  
						
					</div>
				</td>
			</tr>
			
			
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

