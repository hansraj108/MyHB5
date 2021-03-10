<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>

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
	
		
</head><body>   
<s:url var="url_uhome" value="/"/>
    <s:url var="url_cform" value="/stud_form"/>
    <s:url var="url_slist" value="/stud/stud_list"/>
<nav class="navbar navbar-expand-sm bg-success navbar-dark">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="${url_uhome}">Home</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="${url_cform}">Add Student</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="${url_slist}">Student List</a>
    </li>
    </ul>
</nav>  
   
    <%-- General User is logged in : User Menu --%>
    
    <%-- <a href="${url_uhome}">Home</a> | <a href="${url_cform}">Add Student</a> | <a href="${url_slist}">Student List</a> --%>  

</body>
</html>


