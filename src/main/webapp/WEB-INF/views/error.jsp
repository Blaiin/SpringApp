<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
    <h1>Oops! Something went wrong.</h1>
    <p>Sorry, but an error occurred. Please try again later.</p>
    <p>
        <!-- Include information about the error -->
        ${error}
    </p>
</body>
</html>
