<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title> Spring Boot Example</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>

</head>
<body>
<div>
<div class="container" style="margin:50px">
    <div class="row text-center"><strong> User Details</strong></div>
    <div class="row" style="border:1px solid green;padding:10px">
        <div class="col-md-3 text-center"><strong>userid</strong></div>
        <div class="col-md-3 text-center"><strong>Name</strong></div>
        <div class="col-md-3 text-center"><strong>Phone</strong></div>
        <div class="col-md-3 text-center"><strong>email</strong></div>
        <div class="col-md-3 text-center"><strong>address</strong></div>
        <div class="col-md-3 text-center"><strong>loginname</strong></div>
    </div>
        <c:forEach var="user" items="${users}">
            <div class="row" style="border:1px solid green;padding:10px">
            <div class="col-md-3 text-center">${user.userId}</div>
            <div class="col-md-3 text-center" >${user.name}</div>
            <div class="col-md-3 text-center">${user.phone}</div>
            <div class="col-md-3 text-center">${user.email}</div>
            <div class="col-md-3 text-center">${user.address}</div>
            <div class="col-md-3 text-center">${user.loginName}</div>
            </div>
        </c:forEach>

</div>
</div>
</body>
</html>
