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
    <h1>Create a Project</h1>
    <form:form action="/projects/new" method="post" modelAttribute="project">
        <p>
            <form:label path="title">Title: </form:label>
            <form:errors path="title"/>
            <form:input path="title"/>
        </p>

        <p>
            <form:label path="description">Description: </form:label>
            <form:errors path="description"/>
            <form:textarea path="description"/>
        </p>

        <p>
            <form:label path="dueDate">Due Date: </form:label>
            <form:errors path="dueDate"/>
            <form:input path="dueDate" type="date"/>
        </p>

        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>