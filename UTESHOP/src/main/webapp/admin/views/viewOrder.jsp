<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>View Order</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
<div class="container my-5">
  <h1 class="mb-4">Order Details</h1>

  <!-- Check if order exists -->
  <c:if test="${not empty order}">
    <div class="card mb-4">
      <div class="card-body">
        <h5 class="card-title">Order Information</h5>
        <p class="card-text"><strong>Order ID:</strong> <c:out value="${order.orderId}"/></p>
        <p class="card-text"><strong>Order Date:</strong> <c:out value="${order.orderDate}"/></p>
        <p class="card-text"><strong>Status:</strong> <c:out value="${order.status}"/></p>
        <p class="card-text"><strong>Customer:</strong> <c:out value="${order.customer.name}"/></p>
        <p class="card-text"><strong>Phone:</strong> <c:out value="${order.phone}"/></p>
        <p class="card-text"><strong>Address:</strong> <c:out value="${order.streetNumber}, ${order.ward}, ${order.district}, ${order.cityOfProvince}"/></p>
        <p class="card-text"><strong>Total Cost:</strong> <c:out value="${order.totalCost}"/></p>
        <p class="card-text"><strong>Discount:</strong> <c:out value="${order.discount}"/></p>
        <p class="card-text"><strong>Actual Cost:</strong> <c:out value="${order.actualCost}"/></p>
      </div>
    </div>

    <!-- Order Items -->
    <h5 class="mb-4">Order Items</h5>
    <table class="table table-bordered">
      <thead>
      <tr>
        <th>Product</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Total</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="item" items="${order.orderItems}">
        <tr>
          <td>${item.product.name}</td>
          <td>${item.quantity}</td>
          <td>${item.product.price}</td>
          <td>${item.price}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </c:if>

  <!-- If order not found -->
  <c:if test="${empty order}">
    <p class="text-danger">Order not found.</p>
  </c:if>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
