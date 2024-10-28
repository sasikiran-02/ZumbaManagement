<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.simplilearn.zumbamanagement.Admins.models.Participant" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Participants Management</title>
    <link rel="stylesheet" href="participant.css"> 
</head>
<body>
<div class="container">
    <h2>Participants Management</h2>

    <%
        // Check if we are in edit mode by checking if a participant object is set
        Participant participant = (Participant) request.getAttribute("participant");
        boolean isEditMode = participant != null;
    %>

    <!-- Form to add a new participant or edit an existing one -->
    <form action="participants" method="post" class="mb-4">
        <input type="hidden" name="action" value="<%= isEditMode ? "update" : "add" %>">
        <% if (isEditMode) { %>
            <input type="hidden" name="id" value="<%= participant.getId() %>">
        <% } %>
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" value="<%= isEditMode ? participant.getName() : "" %>" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" name="email" value="<%= isEditMode ? participant.getEmail() : "" %>" required>
        </div>
        <div class="form-group">
            <label for="phone">Phone:</label>
            <input type="text" class="form-control" id="phone" name="phone" value="<%= isEditMode ? participant.getPhone() : "" %>" required>
        </div>
        <div class="form-group">
            <label for="batchId">Batch ID:</label>
            <input type="number" class="form-control" id="batchId" name="batchId" value="<%= isEditMode ? participant.getBatchId() : "" %>" required>
        </div>
        <button type="submit" class="btn <%= isEditMode ? "btn-success" : "btn-primary" %>">
            <%= isEditMode ? "Update Participant" : "Add Participant" %>
        </button>
        <% if (isEditMode) { %>
            <a href="participants?action=list" class="btn btn-secondary">Cancel Edit</a>
        <% } %>
    </form>

    <!-- Table to display all participants -->
    <h3>All Participants</h3>
    <%
        List<Participant> participants = (List<Participant>) request.getAttribute("participants");
        if (participants == null || participants.isEmpty()) {
    %>
        <p>No participants found.</p>
    <%
        } else {
    %>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Batch ID</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Participant p : participants) {
                %>
                    <tr>
                        <td><%= p.getId() %></td>
                        <td><%= p.getName() %></td>
                        <td><%= p.getEmail() %></td>
                        <td><%= p.getPhone() %></td>
                        <td><%= p.getBatchId() %></td>
                        <td>
                            <!-- Edit and Delete Links -->
                            <a href="participants?action=edit&id=<%= p.getId() %>" class="btn btn-warning btn-sm">Edit</a>
                            <a href="participants?action=delete&id=<%= p.getId() %>" class="btn btn-danger btn-sm">Delete</a>
                        </td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    <%
        }
    %>
</div>
</body>
</html>
	