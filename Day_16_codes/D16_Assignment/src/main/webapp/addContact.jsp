<%@ page import="java.lang.String" %>
<%
    String errorMessage = (String) request.getAttribute("errorMessage");
    String name = (String) request.getAttribute("name");
    String phone = (String) request.getAttribute("phone");
    String email = (String) request.getAttribute("email");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Contact</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <h2>Add New Contact</h2>

    <% if (errorMessage != null && !errorMessage.isEmpty()) { %>
        <div class="alert error"><%= errorMessage %></div>
    <% } %>

    <form action="addContact" method="post" class="form-card">
        <label>Name:</label>
        <input type="text" name="name" value="<%= name != null ? name : "" %>" required>

        <label>Phone:</label>
        <input type="text" name="phone" value="<%= phone != null ? phone : "" %>" required>

        <label>Email:</label>
        <input type="email" name="email" value="<%= email != null ? email : "" %>" required>

        <button type="submit">Save Contact</button>
    </form>
    <button class="secondary" onclick="window.location.href='index.jsp'">Back to Home</button>
</div>
</body>
</html>
