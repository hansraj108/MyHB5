<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>

<body>
	<h1>Spring MVC Multiple File Upload Example</h1>

	<form:form method="POST" action="save" modelAttribute="uploadFiles"
		enctype="multipart/form-data">

		<input type="file" name="files" />
		<br><br>
		<input type="file" name="files" />
		<br><br>
		<input type="submit" value="Submit" />

	</form:form>
	<br>
	<hr />
	<h3 style="color: red;">${message}</h3>

</body>
</html>