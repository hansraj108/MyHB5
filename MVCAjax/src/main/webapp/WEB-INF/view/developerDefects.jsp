<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC - Ajax Handling using JQuery</title>
<script src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
<script>
	jQuery(document).ready(function($) {

		$("#submit").click(function(){
			var developerData = {};
			developerData["id"] = $("#id").val();
			developerData["firstName"] = $("#firstName").val();
			developerData["lastName"] = $("#lastName").val();
			
			
			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "getDefectCount",
				data : JSON.stringify(developerData),
				dataType : 'json',				
				success : function(data) {
					$('#defectCountDiv').show();
					$('#highDefects').text(data.high);
					$('#mediumDefects').text(data.medium);
					$('#lowDefects').text(data.low);
				}
			});
		});

	});
</script>	
</head>
<body>
	<h2>Enter Developer Details</h2>
	<table>
		<tr>
			<td>Id</td>
			<td><input type="text" id="id"></td>
		</tr>
		<tr>
			<td>First Name</td>
			<td><input type="text" id="firstName"></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><input type="text" id="lastName"></td>
		</tr>
		
		<tr>
			<td colspan="2"><input type="button" id="submit" value="Submit" /></td>
		</tr>
	</table>
	
	<hr/>
	<div id="defectCountDiv" style="display:none">
		<h3>Defects assigned to you:</h3>
		High    - <b><span id="highDefects"></span></b><br/>
		Medium  - <b><span id="mediumDefects"></span></b><br/>
		Low     - <b><span id="lowDefects"></span></b><br/>
	</div>

</body>
</html>