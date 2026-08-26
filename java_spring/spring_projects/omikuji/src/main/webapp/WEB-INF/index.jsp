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
    <form action="omikuji/grace" method="post">
        <label>Pick any number from 5 to 25:</label><br>
        <input type="number" name="number"/><br>
        <label>Enetr the name of any city:</label><br>
        <input type="text" name="city"/><br>
        <label>Enter the name of any real person:</label><br><br>
        <input type="text" name="person"/><br><br>
        <label>Enter professional endeavor or hobby:</label><br><br>
        <input type="text" name="hobby"/><br><br>
        <label>Enter any type of living thing:</label><br><br>
        <input type="text" name="living"/><br><br>
        <label>Say something nice to someone: </label><br><br>
        <textarea rows="4" cols="30" name="desc"></textarea><br><br>
        <label>Send and show a friend</label><br><br>
        <input type="submit"/>
    </form>
</body>
</html>