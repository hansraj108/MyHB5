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
			<h3>Customer List</h3>
			<c:if test="${err != null}">
			<p class="error">${err}</p>
			</c:if>
			<c:if test="${param.act eq 'sv'}">
			<p class="success">Your Customer Saved Successfully !!!</p>
			</c:if>
			<c:if test="${param.act eq 'del'}">
			<p class="success">Your Customer Deleted Successfully !!!</p>
			</c:if>
			<c:if test="${param.act eq 'ed'}">
			<p class="success">Your Customer Updated Successfully !!!</p>
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
			<c:set var="custListHolder" value="${customerList}" scope="session"></c:set>
			<button>Delete Selected Records</button>
			<table border="1" cellpadding="3"  >
                      <tr>
                      <th>Select</th>
                      <th>Sr.</th>
                      <th>CustID</th>
                      <th>First Name</th>
                      <th>Last Name</th>
                      <th>PHONE</th>
                      <th>EMAIL</th>
                      <th>ADDRESS</th>
                      <th>REMARK</th>
                      <th>MEASUREMENTS</th>
                      <th>ORDERS</th>
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
                      <td>${c.customerId}</td>
                      <td>${c.firstName}</td>
                      <td>${c.lastName}</td>
                      <td>${c.phone}</td>
                      <td>${c.email}</td>
                      <td>${c.address}</td>
                      <td>${c.remark}</td>
                      <s:url var="url_showmeasure" value="/user/showMeasurement">
                      <s:param name="custId" value="${c.customerId}"></s:param>
                      </s:url>
                      <td><a href="${url_showmeasure}">Measurements</a></td>
                      <s:url var="url_showorder" value="/user/showOrders/">
                      <s:param name="customerId" value="${c.customerId}"></s:param>
                       </s:url>
                      <td><a href="${url_showorder}">Orders</a></td>
                      <s:url var="url_del" value="/user/del_customer">
                      <s:param name="custId" value="${c.customerId}"></s:param>
                      </s:url>
                      <s:url var="url_edit" value="/user/edit_customer">
                      <s:param name="custId" value="${c.customerId}"></s:param>
                      </s:url>
                      <td><a href="${url_edit}">EDIT</a> | <a href="${url_del}">DELETE</a></td>
                      </tr>
                      </c:forEach>
                      <tr>
                      <td colspan="12" align="center">
                      <s:url var="url_cform" value="/user/customer_form"></s:url>
                      <a href="${url_cform}">Add New Customer</a>
                      </td>
                      </tr>
                      <tr>
                      <td colspan=12 align="center">
                      <div id="pagination">

    <c:url value="/user/custList" var="prev">
        <c:param name="page" value="${page-1}"/>
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
                <c:url value="/user/custList" var="url">
                    <c:param name="page" value="${i.index}"/>
                </c:url>
                <a href='<c:out value="${url}" />'>${i.index}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <c:url value="/user/custList" var="next">
        <c:param name="page" value="${page + 1}"/>
    </c:url>
    <c:if test="${page + 1 <= maxPages}">
        <a href='<c:out value="${next}" />' class="pn next">Next</a>
    </c:if>
</div>
                      </td>
                      </tr>
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