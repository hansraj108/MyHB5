<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Order - Tailor Master App</title>
<s:url var="url_css" value="/static/css/style.css"></s:url>
<link href="${url_css}" rel="stylesheet" type="text/css" />
</head>
<s:url var="url_bg" value="/static/images/bg.jpg"></s:url>
<body background="${url_bg}">
	<table border="1" width="80%" align="center">
		<tr>
			<td height="80px"><jsp:include page="include/header.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td height="25px"><jsp:include page="include/menu.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td height="350px" valign="top">
				<h3>Add Order</h3> <c:if test="${err != null}">
					<p class="error">${err}</p>
				</c:if> <s:url var="url_osave" value="/user/save_order">
					<s:param name="custId" value="${sessionScope.showOrderCustId}"></s:param>
				</s:url> <f:form action="${url_osave}" modelAttribute="orderAttribute"
					method="post" enctype="multipart/form-data">
					<table border="1">
						<tr>
							<td>Order Name</td>
							<td><f:input path="orderName" /></td>
						</tr>
						<tr>
							<td>Quantity</td>
							<td><f:input path="quantity" /></td>
						</tr>
						<tr>
							<td>Total Price</td>
							<td><f:input path="totalPrice" /></td>
						</tr>
						<tr>
							<td>MeasurementID</td>
							<td><f:select path="measurementId">
									<c:forEach var="list" items="${measurementList}">
										<f:option id="${list.measurementId}"
											value="${list.getMeasurementId()}">${list.getMeasurementId()}</f:option>
											<c:set var="orderFormMeasurementId" value="${list.getMeasurementId()}" scope="session"></c:set>
									</c:forEach>

								</f:select></td>
							<s:url var="url_addmeasure" value="/user/add_measurement">
								<s:param name="custId"
									value="${sessionScope.showMeasurement_custId}"></s:param>
							</s:url>
							<td>
							<a href="${url_addmeasure}">ADD NEW MEASUREMENT</a>
							</td>
						</tr>
						<tr>
							<td>Color</td>
							<td><f:input path="color" /></td>
						</tr>
						<tr>
							<td>Delivery Date</td>
							<td><f:input path="deliveryDate" /></td>
						</tr>
						<td>Remark</td>
						<td><f:textarea path="remark" /></td>
						</tr>
						<tr>
							<td>Upload Photos</td>
							<td><f:input type="file" path="photos" id="photos"
									multiple="multiple" /></td>
						</tr>
						<tr>
							<td>Description</td>
							<td><f:input type="text" path="description" id="description" /></td>
						</tr>

						<tr>
							<td></td>
							<td align="right"><input type="submit" value="Save Order"></td>
						</tr>



					</table>
				</f:form>
			</td>
		</tr>
		<tr>
			<td height="25px"><jsp:include page="include/footer.jsp"></jsp:include>
			</td>
		</tr>

	</table>
</body>
</html>