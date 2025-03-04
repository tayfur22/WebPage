<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer</title>
</head>
<body>
<h2>Customer list</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Ad</th>
        <th>Adress</th>
        <th>Orders count</th>
    </tr>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td>${customer.customerId}</td>
            <td>${customer.name}</td>
            <td>${customer.address}</td>
            <td>${customer.noOfOrdersMade}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>