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
    <c:if test="${currentUrl.endsWith('/add/dojo')}">
        <h1>Add New Dojo</h1>
        <form:form action="/dojos/new" method="post" modelAttribute="dojo">
            <p>
                <form:label path="name">Name: </form:label>
                <form:errors path="name"/>
                <form:input path="name"/>
            </p>
            <input type="submit" value="Submit"/>
        </form:form>
    </c:if>

    <c:if test="${currentUrl.endsWith('/add/ninja')}">
        <h1>Add New Ninja</h1>
        <form:form action="/ninjas/new" method="post" modelAttribute="ninja">
            <p>
                <form:label path="dojo">Dojo</form:label>
                <form:errors path="dojo"/>
                <form:select path="dojo">
                    <form:options items="${dojos}" itemValue="id" itemLabel="name"/>
                </form:select>
            </p>
            <p>
                <form:label path="firstName">First Name: </form:label>
                <form:errors path="firstName"/>
                <form:textarea path="firstName"/>
            </p>
            <p>
                <form:label path="lastName">Last Name:</form:label>
                <form:errors path="lastName"/>
                <form:input path="lastName"/>
            </p>
            <p>
                <form:label path="age">Age:</form:label>
                <form:errors path="age"/>
                <form:input type="number" path="age"/>
            </p>
            <input type="submit" value="Submit"/>
        </form:form>
    </c:if>
</body>
</html>