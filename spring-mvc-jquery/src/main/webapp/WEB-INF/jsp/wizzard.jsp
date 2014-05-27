<%-- 
    Document   : wizzard
    Created on : 2014-05-27, 08:12:20
    Author     : Adrian Lapierre <adrian@softproject.com.pl>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Wizzard!</h1>
        
        <div>
            <b>Step:</b> ${command.step}
        </div>
        
        <div>
            <a href="<c:url value="/wizzard/previous"/>">Wstecz</a> <a href="<c:url value="/wizzard/next"/>">Dalej</a>
        </div>
        
    </body>
</html>
