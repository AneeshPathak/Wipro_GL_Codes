<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home - Wipro Demo</title>
</head>
<body>
    <h2>Welcome, ${fullName}</h2>
    <p><a href="${pageContext.request.contextPath}/logout">Logout</a></p>

    <h3>Users</h3>
    <c:if test="${not empty users}">
        <table border="1" cellpadding="6" cellspacing="0">
            <tr><th>ID</th><th>Username</th><th>Full name</th><th>Email</th></tr>
            <c:forEach var="u" items="${users}">
                <tr>
                    <td>${u.id}</td>
                    <td>${u.username}</td>
                    <td>${u.fullName}</td>
                    <td>${u.email}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <h3>Add User</h3>
    <c:if test="${not empty error}"><p style="color:red">${error}</p></c:if>
    <form method="post" action="${pageContext.request.contextPath}/users/add">
        <label>Username: <input type="text" name="username" value="${newUser.username}"/></label><br/><br/>
        <label>Password: <input type="password" name="password" /></label><br/><br/>
        <label>Full name: <input type="text" name="fullName" value="${newUser.fullName}"/></label><br/><br/>
        <label>Email: <input type="email" name="email" value="${newUser.email}"/></label><br/><br/>
        <button type="submit">Add</button>
    </form>
</body>
</html>
