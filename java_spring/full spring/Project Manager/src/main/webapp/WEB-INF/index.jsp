<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Show</title>
</head>
<body>
    <h1>Project Manager</h1>
    <p>A place for teams to manage projects.</p><br><br>
    <c:if test="${currentUrl.endsWith('/register')}">
        <h1>Register</h1>
        <form:form action="/register" method="post" modelAttribute="user">
            <p>
                <form:label path="firstName">First Name: </form:label>
                <form:errors path="firstName"/>
                <form:input path="firstName"/>
            </p>
            <p>
                <form:label path="lastName">Last Name: </form:label>
                <form:errors path="lastName"/>
                <form:input path="lastName"/>
            </p>
             <p>
                <form:label path="email">Email: </form:label>
                <form:errors path="email"/>
                <form:input path="email"/>
            </p>
            <p>
                <form:label path="password">Password: </form:label>
                <form:errors path="password"/>
                <form:input path="password"/>
            </p>
            <p>
                <form:label path="confirm">Confirm Password: </form:label>
                <form:errors path="confirm"/>
                <form:input path="confirm"/>
            </p>
            <input type="submit" value="Submit"/>
        </form:form>
        <a href="/">Have an account maybe login!</a>
    </c:if>

    <c:if test="${currentUrl.endsWith('/')}">
        <h1>Login</h1>
        <form:form action="/login" method="post" modelAttribute="loginUser">
            <p>
                <form:label path="email">Email: </form:label>
                <form:errors path="email"/>
                <form:input path="email"/>
            </p>
            <p>
                <form:label path="password">Password: </form:label>
                <form:errors path="password"/>
                <form:input path="password"/>
            </p>
            <input type="submit" value="Submit"/>
        </form:form>
        <a href="/register">Dont have an account maybe register!</a>
    </c:if>
</body>
</html>