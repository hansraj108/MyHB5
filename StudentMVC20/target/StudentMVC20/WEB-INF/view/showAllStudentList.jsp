<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Registration - Contact Application</title>
<s:url var="url_css" value="/static/css/style.css" />
<link href="${url_css}" rel="stylesheet" type="text/css" />
<s:url var="url_jqlib" value="/static/js/jquery-3.2.1.min.js" />
<script src="${url_jqlib}"></script>
<script>
	$(document).ready(function() {
		$("#id_check_avail").click(function() {
			$.ajax({
				url : 'check_avail',
				data : {
					username : $("#id_username").val()
				},
				success : function(data) {
					$("#id_res_div").html(data);
				}
			});
		});
	});
</script>
</head>
<s:url var="url_bg" value="/static/images/bg.jpg" />
<body background="${url_bg}">
	<table border="1" width="80%" align="center">
		<tr>
			<td height="80px">
				<%-- Header --%> <jsp:include page="include/header.jsp" />
			</td>
		</tr>
		<tr>
			<td height="25px">
				<%-- Menu --%> <jsp:include page="include/menu.jsp" />
			</td>
		</tr>
		<tr>
			<td height="350px" valign="top">
				<%-- Page Content Area--%>
				<h3>Student List</h3> 
				<c:if test="${err!=null}">
					<p class="error">${err}</p>
				</c:if>
				<c:if test="${param.act eq 'reg'}">
                        <p class="success">Student Registered Successfully.</p>
                    </c:if> 
                <c:if test="${param.act eq 'upd'}">
                        <p class="success">Student updated Successfully. </p>
                    </c:if>   
				<table border="1" cellpadding="3" width="100%">
					<tr>
						<th>SELECT</th>
						<th>ID</th>
						<th>NAME</th>
						<th>DOB</th>
						<th>MOBILE</th>
						<th>COUNTRY</th>
						<th>ACTION</th>
					</tr>

					<c:if test="${empty command}">
						<tr>
							<td align="center" colspan="8" class="error">No Records
								Present</td>
						</tr>
					</c:if>

					<c:forEach var="c" items="${command}" varStatus="st">
						<tr>
							<td align="center"><input type="checkbox" name="cid"
								value="${c.id}" /></td>
							<td>${c.id}</td>
							<td>${c.name}</td>
							<td>${c.dob}</td>
							<td>${c.mobile}</td>
							<td>${c.country}</td>
							<s:url var="url_del" value="/del_student">
								<s:param name="cid" value="${c.id}" />
							</s:url>
							<s:url var="url_edit" value="/edit_student">
								<s:param name="cid" value="${c.id}" />
							</s:url>
							<td><a href="${url_edit}">Edit</a> | <a href="${url_del}">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<tr>
			<td height="25px">
				<%-- Footer --%> <jsp:include page="include/footer.jsp" />
			</td>
		</tr>
	</table>
</body>
</html>
