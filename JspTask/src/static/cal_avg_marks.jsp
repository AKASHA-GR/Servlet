<html>
<head>
    <title>Calculate Average Marks</title>
</head>
<body>
    <h1>Calculate Average Marks</h1>
    <%
        int marks1 = 90;
        int marks2 = 75;
        int marks3 = 85;
        int total = marks1 + marks2 + marks3;
        double average = total / 3.0;
    %>

    <h1>Student Result</h1>

    <p>Total marks: <%= total%></p>
    <p>Average marks: <%= average%></P>

    <p>Don't use scriptlets for large business logic in real applications.<p>

</body>
</html>