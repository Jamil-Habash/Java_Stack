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
    <h1><c:out value="${name}"/></h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Age</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="ninja" items="${ninjas}">
                <tr>
                    <th><c:out value="${ninja.id}"/></th>
                    <th><c:out value="${ninja.firstName}"/></th>
                    <th><c:out value="${ninja.lastName}"/></th>
                    <th><c:out value="${ninja.age}"/></th>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>