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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
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


				<%-- Page Content Area--%>
				<h3>Student Registration</h3>
				<c:if test="${err!=null}">
					<p class="error">${err}</p>
				</c:if>
				<s:url var="url_reg" value="/stud/save_student" />
				<f:form action="${url_reg}" modelAttribute="command" method="post">

					<div class="form-group row">
						<label for="name" class="col-sm-2 col-form-label">Name</label>
						<div class="col-sm-7">
							<input type="text" value="${command.name}" class="form-control"
								name="name" placeholder="Enter Name">
						</div>
					</div>

					<div class="form-group row">
						<label for="dob" class="col-sm-2 col-form-label">DOB</label>
						<div class="col-sm-7">
							<input type="text" value="${command.dob}" class="form-control"
								name="dob" placeholder="DD-MM-YYYY">
						</div>
					</div>
					<div class="form-group row">
						<label for="mobile" class="col-sm-2 col-form-label">Mobile</label>
						<div class="col-sm-7">
							<input type="text" value="${command.mobile}" class="form-control"
								name="mobile" placeholder="Enter Number">
						</div>
					</div>

					<div class="form-group row">
						<label for="country" class="col-sm-2 col-form-label">Country</label>
						<div class="col-sm-7">
							<f:select path="country">
									<c:if test="${command.country != null}">
									<f:option value="${command.country}" />
									<f:options items="${countryLists}" />
									</c:if>
									<c:if test="${command.country == null}">
									
									<f:options items="${countryLists}" />
									</c:if>
							</f:select>	
						</div>
					</div>
					
<%-- 					<div class="form-group row">
						<label for="country" class="col-sm-2 col-form-label">Country</label>
						<div class="col-sm-7">
							<f:select path="country">
									<c:if test="${command.country != null}">
									<f:options value="${command.country}" />
									</c:if>
									<c:if test="${command.country == null}">
									
									<f:options items="${countryLists}" />
									</c:if>
							</f:select>	
						</div>
					</div> --%>
					<button type="submit" class="btn btn-primary">Submit</button>


				</f:form>

				<div class="form-group row">
					<label class="col-sm-2 col-form-label"></label>
					<div class="col-sm-7">
						<jsp:include page="include/footer.jsp" />
					</div>
				</div>
			</div>
		</div>
	</div>
</body>






</html>
