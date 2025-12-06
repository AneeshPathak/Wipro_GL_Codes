<%@ page import="com.contactmanager.model.Contact" %>
<%
    Contact contact = (Contact) request.getAttribute("contact");
    Integer id = (Integer) request.getAttribute("id");
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (contact == null) {
        contact = new Contact();
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Contact</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <h2>Edit Contact</h2>

    <% if (errorMessage != null && !errorMessage.isEmpty()) { %>
        <div class="alert error"><%= errorMessage %></div>
    <% } %>

    <form action="editContact" method="post" class="form-card">
        <input type="hidden" name="id" value="<%= id != null ? id : -1 %>" />

        <label>Name:</label>
        <input type="text" name="name" value="<%= contact.getName() != null ? contact.getName() : "" %>" required>

        <label>Phone:</label>
        <input type="text" name="phone" value="<%= contact.getPhone() != null ? contact.getPhone() : "" %>" required>

        <label>Email:</label>
        <input type="email" name="email" value="<%= contact.getEmail() != null ? contact.getEmail() : "" %>" required>

        <button type="submit">Update Contact</button>
    </form>
    <button class="secondary" onclick="window.location.href='viewContacts'">Back to Contacts</button>
</div>
</body>
</html>
