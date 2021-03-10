<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Contact - Contact App</title>
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
			<h3>Add Contact</h3>
			<c:if test="${err != null}">
			<p class="error">${err}</p>
			</c:if>
			<s:url var="url_csave" value="/user/save_contact"></s:url>
			<f:form action="${url_csave}" modelAttribute="command" method="post"> 
					 <table border="1">
                            <tr>
                                <td>Name</td>
                                <td><f:input path="name"/></td>
                            </tr>
                            <tr>
                                <td>Phone</td>
                                <td><f:input path="phone"/></td>
                            </tr>
                            <tr>
                                <td>Email</td>
                                <td><f:input path="email"/></td>
                            </tr>
                            <tr>
                                <td>Address</td>
                                <td><f:textarea path="address"/></td>
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