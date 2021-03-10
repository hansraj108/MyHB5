<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Index</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h2 align="center" class="text-primary">Spring MVC @ControllerAdvice Example</h2>
            <hr />
     
            <div id="errlinks">
                <span id="errlink1">
                    <a href="<%=request.getContextPath() %>/exception/error" class="btn btn-default">Error</a>
               
               <h3><%=request.getContextPath() %></h3>
                </span>
                <div> </div>
                <span id="errlink2">
                    <a href="<%=request.getContextPath() %>/exception/io-error" class="btn btn-default">I/O Error</a>
                </span>
            </div>
        </div>
    </body>
</html>