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
    <p>You have visted http://localhost:8080 <c:out value="${count}"/> times</p>
    <a href="/">Test another visit?</a><br><br>
    <a href="/reset"><button>RESET THE COUNTER (<'_'>)</button></a>
</body>
</html>