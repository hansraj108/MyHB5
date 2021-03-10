<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC - Employee</title>
</head>
<body>
	<h2>Employee Details</h2>
	<form:form method="post" commandName="employee">

		<table>
			<tr>
				<td><form:label path="visaApproved">is Visa Approved - </form:label></td>
				<td><form:checkbox path="visaApproved" /></td>
			</tr>
			<tr>
				<td><form:label path="languagesKnown">Programming Languages - </form:label></td>
				<td><form:checkbox path="languagesKnown" value="C++" label="C++" /> <form:checkbox
						path="languagesKnown" value="JAVA" label ="JAVA" /> <form:checkbox
						path="languagesKnown" value=".Net" label=".Net" /></td>
			</tr>
			<tr>
				<td><form:label path="hobbies">Hobbies - </form:label></td>
				<td><form:checkboxes path="hobbies" items="${availableHobbies}" /></td>
			</tr>

			<tr>
				<td><form:label path="socialProfiles">Social Profiles - </form:label></td>
				<td><form:checkboxes path="socialProfiles"
						items="${availableSocialProfiles}" value="${key}" label="${value}" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>

	</form:form>
</body>
</html>