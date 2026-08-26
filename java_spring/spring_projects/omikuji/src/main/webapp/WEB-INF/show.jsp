<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="/style.css">
    <script type="text/javascript" src="/script.js"></script>
</head>
<body>
    <h1>Here's Your Omikuji!</h1>
    <div>
        <p>
            In <c:out value="${number}"/> years, you will live in <c:out value="${city}"/> with <c:out value="${person}"/> as your roommate, <c:out value="${hobby}"/> for a living.
            The next time you see a <c:out value="${living}"/>, you will have good luck.
            Also, <c:out value="${desc}"/>.
        </p>
    </div>
    <a href="/omikuji">Go Back</a>
</body>
</html>