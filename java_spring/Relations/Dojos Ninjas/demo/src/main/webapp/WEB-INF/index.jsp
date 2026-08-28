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
    <h1>Dojos</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="dojo" items="${dojos}">
                <tr>
                    <th><c:out value="${dojo.id}"/></th>
                    <th><a href="/dojos/${dojo.id}"><c:out value="${dojo.name}"/></a></th>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>