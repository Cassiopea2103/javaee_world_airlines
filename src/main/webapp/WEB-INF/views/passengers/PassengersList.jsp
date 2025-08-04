<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Passengers</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/passengers.css">
</head>
<body>
<div class="container">
    <h1>Passengers Management</h1>

    <a class="add-btn" href="<%= request.getContextPath() %>">Go to home page</a>
    <a class="add-btn" href="<%= request.getContextPath() %>/PassengersController?action=add-passenger">+ Add a New Passenger</a>
    <hr/>

    <h2>Passengers List (${totalPassengers})</h2>
    <table>
        <thead>
        <tr>
            <th>Username</th>
            <th>Email</th>
            <th>Date of Birth</th>
            <th>Gender</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <core:forEach var="passenger" items="${passengers }">
            <tr>
                <td>${ passenger.username }</td>
                <td>${ passenger.email }</td>
                <td>${ passenger.dateOfBirth }</td>
                <td>${ passenger.gender }</td>
                <td>
                    <a href="#">Edit</a> | <a href="#">Delete</a>
                </td>
            </tr>
        </core:forEach>

        </tbody>
    </table>
</div>
</body>
</html>
