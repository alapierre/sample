<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h1>Events list</h1>

<a href="<c:url value="/add"/>">Add</a><br/><br/>

<c:if test="${not empty message}">
    <h4>${message}</h4>
</c:if>

<c:forEach items="${events}" var="event">
    name: ${event.name}, description: ${event.description}
    <a href="<c:url value="/${event.id}/show"/>">Show</a>
    <a href="<c:url value="/${event.id}/edit"/>">Edit</a>
    <a href="<c:url value="/${event.id}/delete"/>">Delete</a>
    <br/>
</c:forEach>

</body>
</html>
