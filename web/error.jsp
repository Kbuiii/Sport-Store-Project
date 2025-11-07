<%-- 
    Document   : error
    Created on : Nov 7, 2025, 6:59:58 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <c:if test="${not empty msg}">
        <p style="color:red; text-align:center;">${msg}</p>
    </c:if>
</body>
</html>
