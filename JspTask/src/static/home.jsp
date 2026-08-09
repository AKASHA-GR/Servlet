<html>
<head>
    <title>Home</title>
</head>
<body>
    <%@ include file="header.jsp" %>

    <h2>Home Page</h2>

    <p>Welcome to the Inventory Management System.</p>

    <form action="include" method="post">
        Product Name: <input type="text" name="product_name"><br>
        Product Price: <input type="text" name="product_price"><br>
        Product Quantity: <input type="text" name="product_quantity"><br>
        Product Description: <input type="text" name="product_description"><br>
        Product Image: <input type="file" name="product_image"><br>
        <input type="submit" value="Add Product">
    </form>

    <p style="color: red;">${message}</p>

    <%@ include file="footer.jsp" %>
</body>
</html>