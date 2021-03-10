<html>
<head>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<style>
#userform label{
			display: inline-block;
			width: 100px;
			text-align: right;
		}
		#submit{
			padding-center: 100px;
		}
		#userform div{
			margin-top: 1em;
			
		}
		textarea{
			vertical-align: top;
			height: 5em;
		}
			
		.error{
			display: none;
			margin-left: 10px;
		}		
		
		.error_show{
			color: red;
			margin-left: 10px;
		}
		
		input.invalid, textarea.invalid{
			border: 2px solid red;
		}
		
		input.valid, textarea.valid{
			border: 2px solid green;
		}
</style>
<script>
$(function() {
	$("#date").datepicker({
		dateFormat : 'dd-mm-yy'
	});
});
	$(document).ready(function() {
	// Name can't be blank
	$("#uname").on("input", function() {
		var input=$(this);
		var is_name=input.val();
		if(is_name){input.removeClass("invalid").addClass("valid");}
		else{input.removeClass("valid").addClass("invalid");}
	});

	$("#date").on("input", function() {
		var input=$(this);
		var is_name=input.val();
		if(is_name){input.removeClass("invalid").addClass("valid");}
		else{input.removeClass("valid").addClass("invalid");}
	});
	// address can't blank
	$("#address").on("textarea", function(){
		var textarea=$(this);
		var is_textarea=textarea.val(); 
		if(is_textarea){textarea.removeClass("invalid").addClass("valid");}
		else{textarea.removeClass("valid").addClass("invalid");}
		});

	
	});
</script>
</head>
<body>
	<h2>User Reg !</h2>
	<form id="userform" action="userServlet" method="post">
		<div>
		<table align="left" border="1">
			<tr>
				<td> Name:</td>
				<td><input type="text" name="uname" id="uname"  required="required">
				<span class="error">This field is required</span></td>
			</tr>
			<tr>
				<td>Address: </td>
				<td><textarea rows="5" cols="25" name="address"
						id="address" required="required"></textarea>
				</td>
			</tr>
			<tr>
				<td>Birth Date:</td>
				<td> <input type="text" name="date" id="date"  required="required"></td>
			</tr>
			
			<tr>
				<td>Married: </td>
				<td><input type="radio" name="married" id= "married" value="married">Married &nbsp;
							<input type="radio" name="married" id= "unmarried" value="unmarried" checked="checked">Un married &nbsp;
				</td>
			</tr>
			<tr>
				<td>Designation: </td>
				<td><select name="designation">
				<option>Manager</option>
				<option>Dpt.Manager</option>
				<option>Asst</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>Hobbies: </td>
				<td><select name="hobies" id="hobies">
				<option>Skying</option>
				<option>Sky diving</option>
				<option>Boating</option>
				</select>  </td>
			</tr>
			<tr>
				<td>Gender: </td>
				<td><input type="radio" name="gender" id= "gender" value="male">Male &nbsp;
							<input type="radio" name="gender" id= "gender" value="female" checked="checked">Female &nbsp;
				</td>
			</tr>
			
			<tr>
				<td colspan="3" align="right"><input id="submit" type="submit" value="   save  "></td>
			</tr>
		</table>
</div>
	</form>
</body>
</html>
