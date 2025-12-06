<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - Wipro Demo</title>
</head>
<body>
<h2>Login</h2>
<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

<form method="post" action="${pageContext.request.contextPath}/login">
    <label>Username: <input type="text" name="username" /></label><br/><br/>
    <label>Password: <input type="password" name="password" /></label><br/><br/>
    <button type="submit">Login</button>
</form>

<p>Tip: use username <strong>user</strong> and password <strong>pass</strong> to login.</p>
</body>
</html>
