<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<h1>Hello World!</h1>

ala ma kota a kot ma ale

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <p>
        This content will only be visible to users who have
        the "admin" authority in their list of GrantedAuthoritys.
    </p>
</sec:authorize>

<sec:authorize url="/secured">
    <p>
        This content will only be visible to users who are authorized to send requests to the "/secured" URL.
    </p>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
    current user is: <sec:authentication property="principal.username"/><br/>
    authorities: <sec:authentication property="principal.authorities"/><br/><br/>

    <a href="<c:url value="/logout"/>">Wyloguj</a>
</sec:authorize>
</body>
</html>
