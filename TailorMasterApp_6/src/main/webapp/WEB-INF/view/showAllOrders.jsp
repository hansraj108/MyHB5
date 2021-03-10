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
<s:url var="url_jqlib" value="/static/js/jquery-3.5.1.min.js" />
<script src="${url_jqlib}"></script>
<script>
function changeStatus(oid, ostatus){
	//alert(oid+","+ostatus);
	$.ajax({
		url :'change_orderStatus',
		data:{orderId:oid, orderStatus:ostatus},
		success : function (data){
			alert(data);
		}
	}); 
}
</script>
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
							</s:url> --%>
                                                        <s:url var="url_osearch" value="/user/order_search">
								<s:param name="custId" value="${customerId}">
								</s:param>
							</s:url>
							<form action="${url_osearch}">

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
							<th>OrderId</th>
							<th>CustID</th>
                                                        <th>MeasurementID</th>
							<th>Order Name</th>
							<th>Quantity</th>
							<th>Total Price</th>
							<th>Color</th>
							<th>Order Status</th>
							<th>Order Date</th>
							<th>Delivery Date</th>
							<th>Bill Date</th>
							<th>Remark</th>
							<th>Photos</th>
							<th>Action</th>
						</tr>
						<c:if test="${empty orderList}">
							<tr>
								<td colspan="10" class="error">No Records Present</td>
							</tr>
						</c:if>
						<c:forEach var="ol" items="${orderList}" varStatus="st">
							<tr>
								<td align="center"><input type="checkbox" name="orderIds"
									value="${ol.orderId}"></td>
								<td>${st.count}</td>
								<td>${ol.orderId}</td>
								<td>${ol.customerId}</td>
                                                                <td>${ol.measurementId}</td>
								<td>${ol.orderName}</td>
								<td>${ol.quantity}</td>
								<td>${ol.totalPrice}</td>
								<td>${ol.color}</td>
								<%-- 	<td>${ol.orderStatus}</td> --%>
								<td><select id="id_${ol.orderId}"
									onchange="changeStatus(${ol.orderId},$(this).val())">
										<option value="1">Pending</option>
										<option value="2">Ongoing</option>
										<option value="3">Completed</option>
										<option value="4">Delivered</option>
								</select> <script>
								$('#id_${ol.orderId}').val('${ol.orderStatus}');
							</script></td>
								<td>${ol.orderDate}</td>
								<td>${ol.deliveryDate}</td>
								<td>${ol.billDate}</td>
								<td>${ol.remark}</td>
								<c:set var="showOrdersMeasurementId" value="${ol.measurementId}"
									scope="session"></c:set>
								<s:url var="url_orderPhoto" value="/user/showPhoto">
									<s:param name="orderId" value="${ol.orderId}"></s:param>
									<s:param name="custId" value="${ol.customerId}"></s:param>
									<s:param name="measurementId" value="${ol.measurementId}"></s:param>
								</s:url>
								<td><a href="${url_orderPhoto}">Photos</a></td>
								<s:url var="url_del" value="/user/del_measurement">
									<s:param name="measurementId" value="${ol.measurementId}"></s:param>
									<s:param name="custId" value="${m.customerId}"></s:param>
								</s:url>
								<td><a href="${url_del}">DELETE</a></td>
							</tr>
						</c:forEach>
						<tr>
							<s:url var="url_addOrder" value="/user/add_order">
								<s:param name="customerId"
									value="${sessionScope.showOrderCustId}"></s:param>
							</s:url>
							<td colspan="17">
								<h3 align="center">
									<a href="${url_addOrder}">ADD NEW ORDER</a>
								</h3>
							</td>
						</tr>
						<tr>
							<td colspan=17 align="center">
								<div id="pagination">

									<c:url value="/user/showOrders" var="prev">
										<c:param name="page" value="${page-1}" />
									</c:url>
									<c:if test="${page > 1}">
										<a href="<c:out value="${prev}" />" class="pn prev">Prev</a>
									</c:if>

									<c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
										<c:choose>
											<c:when test="${page == i.index}">
												<span>${i.index}</span>
											</c:when>
											<c:otherwise>
												<c:url value="/user/showOrders" var="url">
													<c:param name="page" value="${i.index}" />
												</c:url>
												<a href='<c:out value="${url}" />'>${i.index}</a>
											</c:otherwise>
										</c:choose>
									</c:forEach>
									<c:url value="/user/showOrders" var="next">
										<c:param name="page" value="${page + 1}" />
									</c:url>
									<c:if test="${page + 1 <= maxPages}">
										<a href='<c:out value="${next}" />' class="pn next">Next</a>
									</c:if>
								</div>
							</td>
						</tr>
						<tr>
							<s:url var="url_contactsview" value="/customerList"></s:url>
							<td colspan=17 align="center"><a
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