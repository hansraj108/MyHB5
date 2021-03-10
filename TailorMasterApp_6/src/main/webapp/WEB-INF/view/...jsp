<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List - Tailor Master App</title>
<s:url var="url_css" value="/static/css/style.css"/>
<link href="${url_css}" rel="stylesheet" type="text/css">
</head>
<s:url var="url_bg" value="/static/images/bg.jpg"/>
<body background="${url_bg}">
<h3 align="center">Contact List - My Contact App</h3>
<table border="1" width="80%" align="center">
	<tr height="80px">
		<td>
			<jsp:include page="include/header.jsp"></jsp:include>
		</td>
	</tr>
	<tr height="25px">
			<td>
			<jsp:include page="include/menu.jsp"></jsp:include>	
			</td>
	</tr>
	<tr height="350px" valign="top">
		<td>
			<h3>Contact List</h3>
			<c:if test="${err != null}">
			<p class="error">${err}</p>
			</c:if>
			<c:if test="${param.act eq 'sv'}">
			<p class="success">Your Contact Saved Successfully !!!</p>
			</c:if>
			<c:if test="${param.act eq 'del'}">
			<p class="success">Your Contact Deleted Successfully !!!</p>
			</c:if>
			<c:if test="${param.act eq 'ed'}">
			<p class="success">Your Contact Updated Successfully !!!</p>
			</c:if>
			<table align="center">
				<tr>
					<td>
						<form  action="<s:url value="/user/customer_search"/>">
							<input type="text" value="${param.freeText}" name="freeText" placeholder="Enter Text To Search"/> 
							<button>Find</button>
						</form>
					</td>
				</tr>
			</table>
			</br>
			<form action="<s:url value="/user/bulk_cdelete"></s:url>">
			<button>Delete Selected Records</button>
			<table border="1" cellpadding="3"  >
                      <tr>
                      <th>Select</th>
                      <th>Sr.</th>
                      <th>UserID</th>
                      <th>CustID</th>
                      <th>MeasurementID</th>
                      <th>First Name</th>
                      <th>Last Name</th>
                      <th>PHONE</th>
                      <th>EMAIL</th>
                      <th>ADDRESS</th>
                      <th>REMARK</th>
                      <th>ACTION</th>
                      </tr>
                       <c:if test="${empty customerList}">
                      <tr>
                      	<td colspan="8" class="error">No Records Present</td>
                      </tr>
                      </c:if>
                      <c:forEach var="c" items="${customerList}" varStatus="st">
                      <tr>
                      <td align="center"><input  type="checkbox" name="cid" value="${c.customerId}"> </td>
                      <td>${st.count}</td>
                      <td>${c.userId}</td>
                      <td>${c.customerId}</td>
                      <td>${c.measurementId}</td>
                      <td>${c.firstName}</td>
                      <td>${c.lastName}</td>
                      <td>${c.phone}</td>
                      <td>${c.email}</td>
                      <td>${c.address}</td>
                      <td>${c.remark}</td>
                      <s:url var="url_measure" value="/customer/add_measurement"></s:url>
                      <td><a href="${url_measure}">Add Measurement</a></td>
                      <s:url var="url_del" value="/user/del_customer">
                      <s:param name="cid" value="${c.customerId}"></s:param>
                      </s:url>
                      <s:url var="url_edit" value="/user/edit_customer">
                      <s:param name="cid" value="${c.customerId}"></s:param>
                      </s:url>
                      <td><a href="${url_edit}">EDIT</a> | <a href="${url_del}">DELETE</a></td>
                      </tr>
                      </c:forEach>
                      <tr>
                      <s:url var="url_contactsview" value="/customerList"></s:url>
                      	<td colspan=12 align="center">
					<a href="${url_contactsview}.pdf">Download Pdf File</a> | <a href="${url_contactsview}.xls">Download Xls File</a> | <a href="${url_contactsview}.xlsx">Download Xlsx File</a> | <a href="${url_contactsview}.json">View in JSON format</a> | <a href="${url_contactsview}.xml">View in XML format</a> | <a href="${url_contactsview}">View in HTML format</a>
					</td>
                      </tr>
            </table>
            </form>
		</td>
	</tr>
	<tr height="25px" align="center">
		<td>
			<jsp:include page="include/footer.jsp"></jsp:include>
		</td>
	</tr>
</table>
</body>
</html>