<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Batch Management</title>
    <link rel="stylesheet" type="text/css" href="Batch.css"> <!-- Optional: Link to your CSS file -->
</head>
<body>
<h1>Batch Management</h1>

<!-- Batch List Table -->
<h2>Batch List</h2>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Time</th>
        <th>Instructor</th>
        <th>Max Participants</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="batch" items="${batches}">
        <tr>
            <td>${batch.id}</td>
            <td>${batch.time}</td>
            <td>${batch.instructor}</td>
            <td>${batch.maxParticipants}</td>
            <td>
                <a href="batches?action=edit&id=${batch.id}">Edit</a>
                <a href="batches?action=delete&id=${batch.id}" onclick="return confirm('Are you sure you want to delete this batch?');">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- Batch Form for Adding or Editing -->
<h2>${batch != null ? 'Edit Batch' : 'Add Batch'}</h2>
<form action="batches" method="post">
    <input type="hidden" name="action" value="${batch != null ? 'update' : 'add'}"/>
    <input type="hidden" name="id" value="${batch != null ? batch.id : ''}"/>

    <label for="time">Time:</label>
    <input type="text" name="time" value="${batch != null ? batch.time : ''}" required/>

    <label for="instructor">Instructor:</label>
    <input type="text" name="instructor" value="${batch != null ? batch.instructor : ''}" required/>

    <label for="maxParticipants">Max Participants:</label>
    <input type="number" name="maxParticipants" value="${batch != null ? batch.maxParticipants : ''}" required/>

    <input type="submit" value="Submit"/>
</form>

<!-- Back to Batch List -->
<a href="batches">Back to Batch List</a>
</body>
</html>
