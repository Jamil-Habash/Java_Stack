<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Show</title>
</head>
<body>
    <h1><c:out value="${title}"/></h1>
    <p>Description: <c:out value="${desc}"/></p>
    <p>Language: <c:out value="${lang}"/></p>
    <p>Number of Pages: <c:out value="${numOfPages}"/></p>
    <form action="/delete/book/${id}" method="post">
        <input type="hidden" name="_method" value="delete" >
        <input type="submit" value="Delete" >
    </form>
    <form action="/book/${id}/edit" method="post">
        <input type="hidden" name="_method" value="put" >
        <input type="submit" value="Edit" >
    </form>
</body>
</html>