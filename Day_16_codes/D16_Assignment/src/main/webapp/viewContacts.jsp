<%@ page import="java.util.*, com.contactmanager.model.Contact" %>
<%
    List<Contact> contacts = (List<Contact>) request.getAttribute("contacts");
    if (contacts == null) {
        contacts = new ArrayList<Contact>();
    }
    String message = request.getParameter("message");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Contacts</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <h2>All Contacts</h2>

    <% if (message != null && !message.isEmpty()) { %>
        <div class="alert success"><%= message %></div>
    <% } %>

    <% if (contacts.isEmpty()) { %>
        <p>No contacts found. Please add a contact first.</p>
    <% } else { %>
        <table>
            <thead>
                <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
            <%
                int index = 0;
                for (Contact c : contacts) {
            %>
                <tr>
                    <td><%= (index + 1) %></td>
                    <td><%= c.getName() %></td>
                    <td><%= c.getPhone() %></td>
                    <td><%= c.getEmail() %></td>
                    <td>
                        <a href="editContact?id=<%= index %>">Edit</a> |
                        <a href="deleteContact?id=<%= index %>" 
                           onclick="return confirm('Are you sure you want to delete this contact?');">
                           Delete
                        </a>
                    </td>
                </tr>
            <%
                    index++;
                }
            %>
            </tbody>
        </table>
    <% } %>

    <div class="button-group">
        <button onclick="window.location.href='addContact.jsp'">Add New Contact</button>
        <button class="secondary" onclick="window.location.href='index.jsp'">Back to Home</button>
    </div>
</div>
</body>
</html>
