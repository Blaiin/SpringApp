<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>User List</title>
</head>
<body>

    <h2>User List</h2>

    <table border="1">
        <thead>
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Date of Birth</th>
                <!-- Add other user attributes as needed -->
            </tr>
        </thead>
        <tbody>
            <!-- Iterate through the list of users and display information -->
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.name}</td>
                    <td>${user.surname}</td>
                    <td>${user.phone}</td>
                    <td>${user.email}</td>
                    <td>${user.dateOfBirth}</td>
                    <!-- Add other user attributes as needed -->
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
