<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Document List - My Contact App</title>
<s:url value="/user/doclist1" var="url_page"></s:url>
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
			<h5>Document List</h5>
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
			<c:if test="${param.act eq 'doc_del'}">
			<p class="success">Your Document Deleted Successfully !!!</p>
			</c:if>
			<c:if test="${param.act eq 'docs_del'}">
			<p class="success">Your Documents Deleted Successfully !!!</p>
			</c:if>
			<table align="center">
				<tr>
					<td>
						<form  action="<s:url value="/user/document_search"/>">
							<input type="text" value="${param.freeText}" name="freeText" placeholder="Enter Text To Search"/> 
							<button>Find</button>
						</form>
					</td>
				</tr>
			</table>
			</br>
			<form action="<s:url value="/user/bulk_docdelete"></s:url>" modelAttribute="userDocument">
			<c:set var="docListHolder" value="${documentList}" scope="session"></c:set>
			<button>Delete Selected Records</button>
			<table border="1" cellpadding="3"  >
                      <tr>
                      <th>SELECT</th>
                      <th>SR</th>
                      <th>ID</th>
                      <th>userId</th>
                      <th>File Name</th>
                      <th>Description</th>
                      <th>Type</th>
                      <th width="100"></th>
                      <th width="100"></th>
                      </tr>
                       <c:if test="${empty documentList}">
                      <tr>
                      	<td colspan="8" class="error">No Records Present</td>
                      </tr>
                      </c:if>
                     <%--  <c:forEach var="d" items="${documentList}" varStatus="st"> --%>
                      <c:forEach var="d" items="${docListHolder.pageList}"> 
                      <tr>
                      <td align="center"><input  type="checkbox" name="did" value="${d.id}"> </td>
                      <td>${st.count}</td>
                      <td>${d.id}</td>
                      <td>${d.userId}</td>
                      <td>${d.name}</td>
                       <td>${d.description}</td>
                      <td>${d.type}</td>
                      <s:url var="url_downdoc" value="/download_document">
                      </s:url>
                      <td><a href="${url_downdoc}_${d.userId}_${d.id}">Download</a></td>
                      
                      <s:url var="url_deletedoc" value="/delete_document">
                      </s:url>
					  <td><a href="${url_deletedoc}_${d.userId}_${d.id}">Delete</a></td>
                      </c:forEach>
                      <tr>
                      <td colspan="9">
	<c:choose>
        <c:when test="${pageListHolder.firstPage}">Prev</c:when>
        <c:otherwise><a href="${url_page}/prev">Prev</a></c:otherwise>
    </c:choose>
    </span>
    <span>
    <c:forEach begin="0" end="${docListHolder.pageCount-1}" varStatus="loop">
    &nbsp;&nbsp;
    <c:choose>
        <c:when test="${loop.index == docListHolder.page}">${loop.index+1}</c:when>
        <c:otherwise><a href="${url_page}/${loop.index}">${loop.index+1}</a></c:otherwise>
    </c:choose>
    &nbsp;&nbsp;
    </c:forEach>
    </span>
    <span>
    <c:choose>
        <c:when test="${pageListHolder.lastPage}">Next</c:when>
        <c:otherwise><a href="${url_page}/next">Next</a></c:otherwise>
    </c:choose>
    </span>
    </td>
	</tr>
                      <tr>
                      
                      <s:url var="url_contactsview" value="/contactList"></s:url>
                      	<td colspan=8 align="center">
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