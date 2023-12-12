<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: black !important;
            color: black !important;
            margin: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }
        .login-container {
            background-color: #04bd2c;
            color: black;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .login-form {
            background-color: #04bd2c;
            color: black;
            border: 1px solid #ccc;
            padding: 20px;
            border-radius: 5px;
            background-color: #f8f8f8;
        }
        .form-group {
            background-color: #04bd2c;
            color: black;
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            margin-top: 5px;
        }
        input {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }
        .login-button {
            background-color: #246dd4;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            margin-top: 10px;
        }
        .login-button:hover {
            background-color: #09479e;
        }
    </style>
</head>
<body>

<div class="login-container">
    <div class="login-form">
        <h2>Login</h2>
        <form action="login" method="post">
            <label for="email">Username:</label>
            <input type="text" id="email" name="email" required>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            <button type="submit" class="login-button">Login</button>
        </form>
    </div>
</div>

</body>
</html>
