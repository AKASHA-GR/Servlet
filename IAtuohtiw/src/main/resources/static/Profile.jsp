<html>
<head>
    <title>Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1 {
            color: #333;
        }
        a {
            display: block;
            margin: 10px 0;
            text-decoration: none;
            color: #007BFF;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h1>Welcome to the Profile Page</h1>
<p> I am ${userName}</p>
<p>This is the Profile page of our application.</p>

<form action="update" method="post">
    Name : <input type="text" name="name"><br>
    Email : <input type="text" name="email"><br>
    <input type="submit" value="Update">
</form>




</body>
</html>