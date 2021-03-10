<!DOCTYPE html>  
<html>  
<head>  
<meta charset="ISO-8859-1">  
<title>Insert title here</title>  
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#bdatepicker").datepicker({
					dateFormat : 'yy-mm-dd'
				});
            });
            $(function () {
                $("#mdatepicker").datepicker({
					dateFormat : 'yy-mm-dd'
				});
            });
            $(function () {
                $("#tdatepicker").datepicker({
					dateFormat : 'yy-mm-dd'
				});
            });
        </script>
</head>  
<body>  
  
<h1>Add New User</h1>  
<form action="userServlet" method="post">  
<table border="1" style="float:left">  
<tr><td>First Name:</td><td><input type="text" name="firstName"/></td></tr>  
<tr><td>Last Name:</td><td><input type="text" name="lastName"/></td></tr> 
<tr><td>EmailID:</td><td><input type="email" name="email"/></td></tr>  
<tr><td>Mobile:</td><td><input type="text" name="mobile"/></td></tr> 
<tr><td>Address</td><td><textarea name="address" rows="5" cols="25"/></textarea></td></tr> 
<tr><td>Designation</td>
<td>
<select name="designation">
	<option value="" selected>---Select value---</option>
	<option value="manager">Manager</option>
	<option value="deptManager">Dept.Manager</option>
	<option value="worker">Worker</option>
</select>
</td>
</tr>  
<tr><td>Password</td><td><input type="password" name="password"/></td></tr>  
<tr><td>DOB</td><td><input type="text" name="dob" id="bdatepicker"/></td></tr>  
<tr><td>Education</td>
<td>
<select name="education" multiple="multiple">
	<option value="mba" >MBA</option>
    <option value="be" >BE/B.TECH</option>
    <option value="diploma" >Diploma</option>
    <option value="12th" >12th</option>
</select>
</td></tr>  
<tr><td>FavColor</td><td><input type="color" name="favColor" placeholder="Enter Color"/></td></tr>  
<tr><td>FavWeekDay</td><td><input type="week" name="favWeek" placeholder="Enter Week"/></td></tr>  
<tr><td>MonthOfBirth</td><td><input type="text" name="birthMonth" id ="mdatepicker" placeholder="Enter Birth Month"/></td></tr>  
<tr><td>Birth Time</td><td><input type="text" name="birthTime" id ="tdatepicker"  placeholder="Enter Birth Time"/></td></tr>  
<tr><td>Married</td><td><input type="checkbox" name="married" value="married"/>Married</td></tr>  
<tr>
          <td>Gender::   </td>
          <td><input type="radio" name="gender" value="M">Male &nbsp;
                  <input type="radio" name="gender" value="F" checked>FeMale &nbsp;
          </td>
        </tr>
<tr>
          <td>Hobies:: </td>
          <td name="hobies">
               <input type="checkbox" name="hb"  value="reading">Reading books &nbsp;
               <input type="checkbox" name="hb"  value="sleeping" checked>Meditation &nbsp;
               <input type="checkbox" name="hb"  value="cooking">Cooking &nbsp;
               <input type="checkbox" name="hb"  value="roaming">Traveling &nbsp;
          </td>
        </tr>
  
 

<tr>
<td align="center" colspan="2"><input type="reset"  name="cancel"> <input type="submit" value="Save User"/> </td>
</tr>  
</table>  
</form>  
  

  
</body>  
</html>  