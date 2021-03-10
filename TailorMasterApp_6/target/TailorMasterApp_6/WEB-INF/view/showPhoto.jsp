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
					<p class="success">Your Order Saved Successfully !!!</p>
				</c:if> <c:if test="${param.act eq 'del'}">
					<p class="success">Your Order Deleted Successfully !!!</p>
				</c:if> <c:if test="${param.act eq 'delBulk'}">
					<p class="success">Your Selected Orders Deleted Successfully
						!!!</p>
				</c:if> <c:if test="${param.act eq 'ed'}">
					<p class="success">Your Order Updated Successfully !!!</p>
				</c:if>
				<table align="center">
					<tr>
						<td>
							<%-- <s:url value="/user/measurement_search" var="url_search">
								<s:param name="custId" value="${sessionScop.showMeasurement_custId}" />
							</s:url> --%> <s:url var="url_msearch"
								value="/user/measurement_search">
								<s:param name="custId" value="${customerId}">
								</s:param>
							</s:url>
							<form action="${url_msearch}">

								<input type="text" value="${param.freeText}" name="freeText"
									placeholder="Enter Text To Search" />
								<button>Find</button>
							</form>
						</td>
					</tr>
				</table> </br> <s:url value="/user/bulk_mdelete" var="url_bulkdelete">
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
								<td align="center"><input type="checkbox" name="orderIds"
									value="${ol.orderId}"></td>
								<td>${st.count}</td>
								<td>${ol.photoId}</td>
								<td>${ol.orderId}</td>
								<td>${ol.measurementId}</td>
								<td>${ol.name}</td>
								<td>${ol.type}</td>
								<td>${ol.description}</td>
								<td>${ol.saveDate}</td>
								<s:url var="url_downImage" value="/download_image">
								</s:url>
								<td><a href="${url_downImage}_${ol.orderId}_${ol.photoId}">Download</a></td>

								<s:url var="url_deleteImage" value="/delete_image">
								</s:url>
								<td><a href="${url_deleteImage}_${d.userId}_${d.id}">Delete</a></td>
							</tr>
						</c:forEach>
						<tr>
							<s:url var="url_addOrder" value="/user/add_order">
								<s:param name="custId" value="${sessionScope.showOrder_custId}"></s:param>
							</s:url>
							<td colspan="15">
								<h3 align="center">
									<a href="${url_addOrder}">ADD NEW ORDER</a>
								</h3>
							</td>
						</tr>
						<tr>
							<s:url var="url_contactsview" value="/customerList"></s:url>
							<td colspan=15 align="center"><a
								href="${url_contactsview}.pdf">Download Pdf File</a> | <a
								href="${url_contactsview}.xls">Download Xls File</a> | <a
								href="${url_contactsview}.xlsx">Download Xlsx File</a> | <a
								href="${url_contactsview}.json">View in JSON format</a> | <a
								href="${url_contactsview}.xml">View in XML format</a> | <a
								href="${url_contactsview}">View in HTML format</a></td>
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