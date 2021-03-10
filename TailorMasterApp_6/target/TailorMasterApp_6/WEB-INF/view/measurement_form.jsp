<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Measurement - Tailor Master App</title>
<s:url var="url_css" value="/static/css/style.css"></s:url>
<link href="${url_css}" rel="stylesheet" type="text/css"/>
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
			<h3>Add Measurement</h3>
			<c:if test="${err != null}">
			<p class="error">${err}</p>
			</c:if>
			<s:url var="url_msave" value="/user/save_measurement">
			<s:param name="custId" value="${editCustomerId}"></s:param>
			</s:url>
			<f:form action="${url_msave}" modelAttribute="command" method="post"> 
					 <table border="1">
                            <tr>
                                <td>Last Update Date (mm/dd/yyyy)</td>
                                <td><f:input path="lastUpdate"/></td>
                            </tr>
                            <tr>
                                <td>Shirt Length</td>
                                <td><f:input path="shirtLength"/></td>
                            </tr>
                            <tr>
                                <td>Arm Length</td>
                                <td><f:input path="armLength"/></td>
                            </tr>
                            <tr>
                                <td>Neck</td>
                                <td><f:input path="neck"/></td>
                            </tr>
                            <tr>
                                <td>Chest</td>
                                <td><f:input path="chest"/></td>
                            </tr>
                            <tr>
                                <td>Waist</td>
                                <td><f:input path="waist"/></td>
                            </tr>
                            <tr>
                                <td>Remark</td>
                                <td><f:input path="remark"/></td>
                            </tr>
                            
                           <td colspan="2" align="right">
                                    <button>Submit</button> <br/>
                                </td>
                            </tr>
                        </table>
			</f:form>
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