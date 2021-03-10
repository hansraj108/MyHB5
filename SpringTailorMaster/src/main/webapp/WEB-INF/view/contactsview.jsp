<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title> Spring Contact App</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>

</head>
<body>
<div>
<div class="container" style="margin:50px">
    <div class="row text-center"><strong> Contacts Details</strong></div>
    <div class="row" style="border:1px solid green;padding:10px">
        <div class="col-md-3 text-center"><strong>userid</strong></div>
        <div class="col-md-3 text-center"><strong>contactid</strong></div>
        <div class="col-md-3 text-center"><strong>Name</strong></div>
        <div class="col-md-3 text-center"><strong>Phone</strong></div>
        <div class="col-md-3 text-center"><strong>email</strong></div>
        <div class="col-md-3 text-center"><strong>address</strong></div>
        <div class="col-md-3 text-center"><strong>Remark</strong></div>
    </div>
        <c:forEach var="contact" items="${contacts}">
            <div class="row" style="border:1px solid green;padding:10px">
            <div class="col-md-3 text-center">${contact.userId}</div>
            <div class="col-md-3 text-center">${contact.contactId}</div>
            <div class="col-md-3 text-center" >${contact.name}</div>
            <div class="col-md-3 text-center">${contact.phone}</div>
            <div class="col-md-3 text-center">${contact.email}</div>
            <div class="col-md-3 text-center">${contact.address}</div>
            <div class="col-md-3 text-center">${contact.remark}</div>
            </div>
        </c:forEach>

</div>
</div>
</body>
</html>
