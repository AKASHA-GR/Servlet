<html>
<body>

<h2>Student Details</h2>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="name" value="Akasha" />
<c:set var="marks" value="85" />

Student Name: ${name}<br>
Marks: ${marks}<br>

<c:if test="${marks >= 50}">
    Result: Pass
</c:if>

</body>
</html>