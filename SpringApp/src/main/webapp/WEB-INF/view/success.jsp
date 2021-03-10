<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Spring MVC - Employee</title>
</head>
<body>
	<h2>Employee Data</h2>

	<table>
		<tr style="height:75px">
			<td>is Visa Approved - </td>
			<td>${employee.visaApproved}</td>
		</tr>
		<tr style="height:75px">
			<td>Selected Programming Languages - </td>
			<td>
				<c:forEach var="languageKnown" 	items="${employee.languagesKnown}">
					${languageKnown} <br />
				</c:forEach>
			</td>
		</tr>
		<tr style="height:75px">
			<td>Hobbies - </td>
			<td>
				<c:forEach var="hobby" items="${employee.hobbies}">
					${hobby} <br />
				</c:forEach>
			</td>
		</tr>

		<tr style="height:75px">
			<td>Selected Social Profiles - </td>
			<td>
				<c:forEach var="socialProfile"	items="${employee.socialProfiles}">
						${socialProfile} <br />
				</c:forEach>
			</td>
		</tr>

	</table>


</body>
</html>