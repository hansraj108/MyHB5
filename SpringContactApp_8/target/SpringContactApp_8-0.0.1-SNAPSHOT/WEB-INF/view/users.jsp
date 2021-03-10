<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users List - Contact App</title>
<s:url var="url_css" value="/static/css/style.css"></s:url>
<link href="url_css" rel="stylsheet" type="text/css"/>
<s:url var="url_jqlib" value="/static/js/jquery-3.5.1.min.js"/>
<script src="${url_jqlib}"></script>
<script>
function changeStatus(uid, lstatus){
	//alert(uid+","+lstatus);
	$.ajax({
		url :'change_status',
		data:{userId:uid, loginStatus:lstatus},
		success : function (data){
			alert(data);
		}
	});
}
</script>
</head>
<s:url var="url_bg" value="/static/images/bg.jpg"></s:url>
<body background="${url_bg}">
	<table border="1" width="80%" align="center">
		<tr>
			<td height="80px">
			<jsp:include page="include/header.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td height="25px">
			<jsp:include page="include/menu.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td height="350px" valign="top">
			<h3>Users List</h3>
			<table border="1">
				<tr>
						<th>SR</th>
						<th>USERID</th>
						<th>NAME</th>
						<th>PHONE</th>
						<th>EMAIL</th>
						<th>ADDRESS</th>
						<th>USERNAME</th>
						<th>STATUS</th>
				</tr>
				<c:forEach var="u" items="${usersList}" varStatus="st">
					<tr>	
						<td>${st.count}</td>
						<td>${u.userId}</td>
						<td>${u.name}</td>
						<td>${u.phone}</td>
						<td>${u.email}</td>
						<td>${u.address}</td>
						<td>${u.loginName}</td>
						<td>
							<select id="id_${u.userId}" onchange="changeStatus(${u.userId},$(this).val())">
								<option value="1">Active</option>
								<option value="2">Block</option>
							</select>
							<script>
								$('#id_${u.userId}').val('${u.loginStatus}');
							</script>
							${u.loginStatus}
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td>
					<s:url  var="url_usersview" value="/usersList"></s:url>
					<a href="${url_usersview}">Get the Pdf view</a>
					</td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td height="25px">
			<jsp:include page="include/footer.jsp"></jsp:include>
			</td>
		</tr>
	
	</table>
</body>
</html>