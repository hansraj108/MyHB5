<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders List - Tailor Master App</title>
<s:url var="url_css" value="/static/css/style.css" />
<link href="${url_css}" rel="stylesheet" type="text/css">
</head>
<s:url var="url_bg" value="/static/images/bg.jpg" />
<body background="${url_bg}">
	<h3 align="center">Orders List - Tailor Master App</h3>
	<table border="1" width="80%" align="center">
		<tr height="80px">
			<td><jsp:include page="include/header.jsp"></jsp:include></td>
		</tr>
		<tr height="25px">
			<td><jsp:include page="include/menu.jsp"></jsp:include></td>
		</tr>
		<tr height="350px" valign="top">
			<td>
				<h3>Contact List</h3> <c:if test="${err != null}">
					<p class="error">${err}</p>
				</c:if> <c:if test="${param.act eq 'sv'}">
					<p class="success">Your Photo Saved Successfully !!!</p>
				</c:if> <c:if test="${param.act eq 'del'}">
					<p class="success">Your Photo Deleted Successfully !!!</p>
				</c:if> <c:if test="${param.act eq 'delBulk'}">
					<p class="success">Your Selected Photo Deleted Successfully
						!!!</p>
				</c:if> <c:if test="${param.act eq 'ed'}">
					<p class="success">Your Photo Updated Successfully !!!</p>
				</c:if>
				
				<s:url value="/user/bulk_pdelete" var="url_bulkdelete">
				<s:param name="custId" value="${param.custId}"></s:param>
				</s:url>
				<form action="${url_bulkdelete}">
					<button>Delete Selected Records</button>
					<table border="1" cellpadding="3">
						<tr>
							<th>Select</th>
							<th>Sr.</th>
							<th>PhotoID</th>
							<th>OrderID</th>
							<th>MeasurementID</th>
							<th>File Name</th>
							<th>Type</th>
							<th>Description</th>
							<th>Save Date</th>
							<th>Show Image</th>
							<th>Download</th>
							<th>Delete</th>
						</tr>
						<c:if test="${empty photoList}">
							<tr>
								<td colspan="10" class="error">No Records Present</td>
							</tr>
						</c:if>
						<c:forEach var="ol" items="${photoList}" varStatus="st">
							<tr>
								<td align="center"><input type="checkbox" name="photoIds"
									value="${ol.photoId}"></td>
								<td>${st.count}</td>
								<td>${ol.photoId}</td>
								<td>${ol.orderId}</td>
								<td>${ol.measurementId}</td>
								<td>${ol.name}</td>
								<td>${ol.type}</td>
								<td>${ol.description}</td>
								<td>${ol.saveDate}</td>
								
								<%-- <s:url var="url_showImage" value="/user/showSingleImage">
								</s:url>
								<td align="center"><a href="${url_showImage}_${ol.photoId}">Show</a></td> --%>
								<td>
								<img width="100" height="100" src="/user/showSingleImage<c:out value='${ol.photoId}'/>">
								</td>
								<c:set var="showPhotoJspOrderId" value="${ol.orderId}" scope="session"/>
								<c:set var="showPhotoJspMeasurementId" value="${ol.measurementId}" scope="session"/>
								<s:url var="url_downImage" value="/download_image">
								</s:url>
								<td><a href="${url_downImage}_${ol.orderId}_${ol.photoId}_${ol.measurementId}">Download</a></td>

								<s:url var="url_deleteImage" value="/delete_image">
								</s:url>
								<td><a href="${url_deleteImage}_${ol.orderId}_${ol.photoId}_${ol.measurementId}">Delete</a></td>
							</tr>
						</c:forEach>
						<tr>
						</tr>
					</table>
				</form>
			</td>
		</tr>
		<tr height="25px" align="center">
			<td><jsp:include page="include/footer.jsp"></jsp:include></td>
		</tr>
	</table>
</body>
</html>