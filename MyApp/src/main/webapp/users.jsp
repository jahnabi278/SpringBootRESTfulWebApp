<html>
<head><title>User List</title></head>
<body>
    <h2>Users</h2>
    <table border="1">
        <tr>
            <th>userName</th><th>name</th><th>city</th><th>mobile</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.userName}</td>
                <td>${user.name}</td>
                <td>${user.city}</td>
				<td>${user.mobile}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>