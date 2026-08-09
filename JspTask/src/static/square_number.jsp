<html>
<head>
    <title>Square Number</title>
</head>
<body>
    <h1>Square Number</h1>
    <%!
        public int square(int number){
            return number * number;
        }
    %>

    <h1>Square Number</h1>

    <p>The square of 5 is: <%= square(5) %></p>
    <p>The square of 10 is: <%= square(10) %></p>

    <p>Understand how methods/fields can be declared in JSP.</p>
</body>
</html>