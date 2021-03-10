<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>


    <%-- General User is logged in : User Menu --%>
    <s:url var="url_uhome" value="/"/>
    <s:url var="url_cform" value="/user/contact_form"/>
    <s:url var="url_slist" value="/studentList"/>
    <a href="${url_uhome}">Home</a> | <a href="${url_cform}">Add Contact</a> | <a href="${url_slist}">Contact List</a> | <a href="${url_logout}">Logout</a>  




