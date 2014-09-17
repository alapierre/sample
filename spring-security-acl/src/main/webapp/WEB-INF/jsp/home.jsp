<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
        the "admin" authority in their list of <tt>GrantedAuthority</tt>s.
    </p>
</sec:authorize>

<sec:authorize url="/admin">
    <p>
        This content will only be visible to users who are authorized to send requests to the "/admin" URL.
    </p>
</sec:authorize>

current user is: <sec:authentication property="principal.username"/><br/>
authorities: <sec:authentication property="principal.authorities"/><br/>
pass: <sec:authentication property="principal.password"/><br/>
</body>
</html>
