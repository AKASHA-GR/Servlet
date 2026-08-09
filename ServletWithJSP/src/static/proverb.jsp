<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
    <h2>Proverb</h2>

    <form action="proverb" method="post">
        Proverb: <input type="text" id="proverb" name="proverb" required><br><br>
        Author: <input type="text" id="author" name="author" required><br><br>
        Category: <input type="text" id="category" name="category" required><br><br>
        Meaning: <input type="text" id="meaning" name="meaning" required><br><br>
        <input type="submit" value="Register">
    </form>

    <span style = "color: green;">${message}</span>

</body>
</html>