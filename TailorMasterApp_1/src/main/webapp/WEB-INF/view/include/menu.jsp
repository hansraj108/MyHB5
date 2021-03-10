<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<s:url var="url_logout" value="/logout"></s:url>
<s:url var="url_reg" value="/reg_form"></s:url>

<c:if test="${sessionScope.userId == null}">
<s:url var="url_ghome" value="/index"></s:url>
<a href="${url_ghome}">Home</a> | <a href="${url_ghome}">Login</a> | <a href="${url_reg}">Register</a> | <a href="#">About</a> | <a href="#">Help</a>
</c:if>
<c:if test="${sessionScope.userId != null && sessionScope.role == 1}">
<s:url var="url_ulist" value="/admin/users"></s:url>
<s:url var="url_ahome" value="/admin/dashboard"></s:url>
<a href="${url_ahome}">Home</a> | <a href="${url_ulist}">User List</a> | <a href="${url_logout}">Logout</a>
</c:if>
<c:if test="${sessionScope.userId != null && sessionScope.role == 2}">
<s:url var="url_cform" value="/user/contact_form"></s:url>
<s:url var="url_uhome" value="/user/dashboard"></s:url>
<s:url var="url_clist" value="/user/clist"></s:url>
<s:url var="url_docform" value="/user/doc_form"></s:url>
<s:url var="url_doclist" value="/user/doclist1"></s:url>
<a href="${url_uhome}">Home</a> | <a href="${url_cform}">Add Contact</a> | <a href="${url_clist}">Contact List</a> | <a href="${url_docform}">Add Document</a> | <a href="${url_doclist}">Document List</a> | <a href="${url_logout}">Logout</a>
</c:if>