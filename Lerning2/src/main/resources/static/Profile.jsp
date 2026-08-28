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
<p> I am ${message}</p>
<p>This is the Profile page of our application.</p>

<form action="profileUpdate" method="post">
    Name : <input type="text" name="name"><br>
    <input type="submit" value="Update">
</form>

<p>The Name is Updated.</p>
<p>The updated name is ${NameUpdate}</p>




</body>
</html>