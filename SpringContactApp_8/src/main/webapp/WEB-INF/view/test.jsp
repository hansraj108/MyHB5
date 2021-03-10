<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajax test page</title>
<s:url var="url_jqlib" value="/static/js/jquery-3.5.1.min.js"/>
<script src="${url_jqlib}"></script>
<script>
$(document).ready(function(){
	$("#get_server_time").click(function(){
		//alert('hans');
		$.ajax({
			url : 'get_time',
			success : function (data){
				$("#get_time").html(data);
			}
		});
	});
});
</script>
</head>
<body>
<h1>Ajax test page</h1>
<button id="get_server_time">get serv time</button>
<p id="get_time"></p>

</body>
</html>