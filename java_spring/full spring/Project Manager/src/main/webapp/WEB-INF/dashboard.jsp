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
    <h1>Welcome, <c:out value="${firstName}"/></h1>
    <a href="/logout">Logout</a>
    <h2>All Projects</h1>
    <a href="/projects/new"><button>Add New Project</button></a>
    <table>
        <thead>
            <tr>
                <th>Project</th>
                <th>Team Lead</th>
                <th>Due Date</th>
                <th>Actions</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="project" items="${availableProjects}">
                <tr>
                    <td>
                        <c:out value="${project.title}"/>
                    </td>

                    <td>
                        <c:out value="${project.teamLead.firstName}"/>
                    </td>

                    <td>
                        <c:out value="${project.dueDate}"/>
                    </td>

                    <td>
                        <a href="/addToList/${project.id}">
                            Join Team
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <h2>Your Projects</h2>

    <table>
        <thead>
            <tr>
                <th>Project</th>
                <th>Team Lead</th>
                <th>Due Date</th>
                <th>Actions</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="project" items="${userProjects}">
                <tr>
                    <td>
                        <c:out value="${project.title}"/>
                    </td>

                    <td>
                        <c:out value="${project.teamLead.firstName}"/>
                    </td>

                    <td>
                        <c:out value="${project.dueDate}"/>
                    </td>

                    <td>

                        <c:choose>

                            <c:when test="${project.teamLead.id == user.id}">
                                <a href="/projects/edit/${project.id}">
                                    Edit
                                </a>
                            </c:when>

                            <c:otherwise>
                                <a href="/leaveTeam/${project.id}">
                                    Leave Team
                                </a>
                            </c:otherwise>

                        </c:choose>

                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>