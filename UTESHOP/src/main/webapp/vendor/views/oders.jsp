<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Order Management</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1 class="text-center">Order Management</h1>

    <!-- Order List Table -->
    <table class="table table-bordered table-hover mt-3">
        <thead class="table-dark">
        <tr>
            <th>Order ID</th>
            <th>Order Date</th>
            <th>Status</th>
            <th>City of Province</th>
            <th>Phone</th>
            <th>Actual Cost</th>
        </tr>
        </thead>
        <tbody>
        <!-- Using c:forEach to iterate through the order list -->
        <c:forEach var="order" items="${listOrder}">
            <tr>
                <td>${order.orderId}</td>
                <td>${order.orderDate}</td>
                <td>${order.status}</td>
                <td>${order.cityOfProvince}</td>
                <td>${order.actualCost}</td>
            </tr>
        </c:forEach>
        <!-- Display message if the order list is empty -->
        <c:if test="${empty listOrder}">
            <tr>
                <td colspan="6" class="text-center">No orders available!</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>

<!-- Bootstrap JS and Popper.js (required for modal functionality) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
