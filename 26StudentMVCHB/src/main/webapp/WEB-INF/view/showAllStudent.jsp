<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<!-- <link href="/static/bootstrap/bootstrap.min.css" rel="stylesheet"> -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Registration - Student Application</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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
<div class="container">
<div class="card">
			<div class="card-body">

				<div class="form-group row">
					<label class="col-sm-15 col-form-label"></label>
					<div class="col-sm-15">
						<jsp:include page="include/header.jsp" />
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-15 col-form-label"></label>
					<div class="col-sm-15">
						<jsp:include page="include/menu.jsp" />
					</div>
				</div>
				</div>
				</div>
				</div>
				</div>
<s:url var="url_bg" value="/static/images/bg.jpg" />
<body background="${url_bg}">
	<div class="container">
		<div class="card">
			<div class="card-body">
				<h3>Student List</h3> <c:if test="${err!=null}">
					<p class="error">${err}</p>
				</c:if> <c:if test="${param.act eq 'reg'}">
					<p class="success">Student Registered Successfully.</p>
				</c:if> <c:if test="${param.act eq 'upd'}">
					<p class="success">Student updated Successfully.</p>
				</c:if> <c:if test="${param.act eq 'del'}">
					<p class="success">Students are deleted Successfully.</p>
				</c:if>
						<nav class="navbar navbar-expand-sm bg-light navbar-dark justify-content-end">
							<form class="form-inline" action="<s:url value="/stud_search"/>">
								<input type="text" name="freeText" value="${param.freeText}"
									placeholder="Enter Text To Search">
								<button class="btn btn-success float-right" type="submit">Find</button>
							</form>
							</nav>
				
				<nav class="navbar navbar-expand-sm bg-light navbar-dark justify-content-end">		
				<form class="form-inline" action="<s:url value="/stud/bulk_cdelete"/>">
					<button class="btn btn-success float-right">Delete Selected Records</button>
					<br />
					<br />
					<div class="container">
					<table class="table table-hover">
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
									value="${c.id}"/></td>
								<td>${c.id}</td>
								<td>${c.name}</td>
								<td>${c.dob}</td>
								<td>${c.mobile}</td>
								<td>${c.country}</td>
								<s:url var="url_del" value="/stud/del_student">
									<s:param name="cid" value="${c.id}" />
								</s:url>
								<s:url var="url_edit" value="/edit_student">
									<s:param name="cid" value="${c.id}" />
								</s:url>
								<td><a href="${url_edit}" class="btn btn-warning" role="button">Edit</a><a href="${url_del}" class="btn btn-danger" role="button">Delete</a></td>
							</tr>
						</c:forEach>
					</table>
					</div>
				</form>
				</nav>
			
		<div class="form-group row">
					<label class="col-sm-2 col-form-label"></label>
					<div class="col-sm-7">
						<jsp:include page="include/footer.jsp" />
					</div>
				</div>
</body>
</html>
