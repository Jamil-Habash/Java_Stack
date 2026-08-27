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
    <h1>Add Book</h1>
    <form:form action="/add/books" method="post" modelAttribute="book">
        <p>
            <form:label path="title">Title</form:label>
            <form:errors path="title"/>
            <form:input path="title"/>
        </p>

        <p>
            <form:label path="description">Description</form:label>
            <form:errors path="description"/>
            <form:textarea path="description"/>
        </p>

        <p>
            <form:label path="language">Language</form:label>
            <form:errors path="language"/>
            <form:input path="language"/>
        </p>

        <p>
            <form:label path="numberOfPages">Pages</form:label>
            <form:errors path="numberOfPages"/>
            <form:input type="number" path="numberOfPages"/>
        </p>

        <input type="submit" value="Submit"/>

    </form:form>
    <h1>All Books</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Language</th>
                <th>Number of Pages</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${books}">
                <tr>
                    <th><c:out value="${book.id}"/></th>
                    <th><a href="/books/${book.id}"><c:out value="${book.title}"/></a></th>
                    <th><c:out value="${book.language}"/></th>
                    <th><c:out value="${book.numberOfPages}"/></th>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>