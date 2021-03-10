<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users Documents</title>
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
			<h3 align="center">Users Documents</h3>
			<c:if test="${err != null}">
			<p class="error">${err}</p>
			</c:if>
			<h3>Upload New Document</h3>
			<s:url var="url_savedoc" value="/user/savedoc"></s:url>
			<f:form action="${url_savedoc}"  method="post" modelAttribute="userDocument" enctype="multipart/form-data"> 
					 <table border="1">
					 		<tr>
                            <td><label for="file">Upload a document</label></td>
                                <td><f:input type="file" path="files" id="file" multiple="multiple"/></td>
                            </tr>
                            <tr>
                            	<td><label for="description">Description</label></td>
                                <td><f:input type="text" path="description" id="description"/></td>
                            </tr>
                            <tr>
                            	<td></td>
                                <td align="right"><input type="submit" value="Upload"></td>
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