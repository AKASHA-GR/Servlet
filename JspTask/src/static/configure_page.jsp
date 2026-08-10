
<html>
<head>
    <title>Configure Page</title>
    <style>
        body{
            text-align: center;
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            color: #333;
        }

        h1{
            color: #007bff;
        }

        p{
            font-size: 18px;
        }
    </style>
</head>
<body>
    <%@ page contentType= "text/html;charset=UTF-8" language="java" %>
    <%@ page import="java.util.Date" %>


    <h1>Configure Page</h1>

    <p>Current Date and Time:</p><br>

    <p> <%= new Date() %> </p>
</body>
</html>