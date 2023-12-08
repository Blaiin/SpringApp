<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome Page</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: black;
        }

        .header {
            background: #060f78;
            color: #fff;
            text-align: center;
            padding: 20px 0; /* Adjusted padding */
            position: relative;
        }

        .top-buttons {
            color: #09479e;
            position: absolute;
            top: 10px;
            right: 10px;
            display: flex; /* Added flex display for better alignment */
            align-items: center; /* Align items vertically */
        }

        .button {
            color: #fff;
            padding: 12px 15px; /* Adjusted padding */
            font-size: 14px;
            text-decoration: none;
            border-radius: 5px;
            margin-right: 10px;
            cursor: pointer;
        }

        .login-button,
        .register-button {
            background-color: #3498db;
            padding: 10px 12px; /* Adjusted padding */
            font-size: 12px; /* Adjusted font-size */
            border-radius: 5px;
            margin-right: 5px;
        }

        .login-button:hover,
        .register-button:hover {
            background-color: #2980b9;
        }

        .content {
            text-align: center;
            padding: 40px;
            color: #333;
        }
    </style>
</head>
<body>

    <div class="header">
        <div class="top-buttons">
            <a href="about" class="button">About</a>
            <a href="user-list" class="button">User List</a>
            <a href="documentation" class="button">Documentation</a>
            <a href="login" class="button login-button">Login</a>
            <a href="register" class="button register-button">Register</a>
        </div>
        <h1>Welcome to my Website</h1>
        <p>Spring MVC app for data manipulation</p>
    </div>

    <div class="content">
        <p></p>
    </div>
</body>
</html>