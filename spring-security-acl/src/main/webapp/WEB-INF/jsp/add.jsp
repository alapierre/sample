<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<h1>Add!</h1>

<c:url value="/addAction" var="action"/>
<form:form action="${action}" modelAttribute="event" method="post">
    <form:errors path="name"/>
    <form:label path="name">Name</form:label>
    <form:input path="name"/>

    <form:errors path="description"/>
    <form:label path="description">Description</form:label>
    <form:input path="description"/>

    <input type="submit" value="Zapisz"/>
</form:form>
</body>
</html>
