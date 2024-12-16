<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Profile</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
<div class="container my-5">
  <h1 class="mb-4">Customer Profile</h1>
  <!-- Check if customer exists -->
  <c:if test="${not empty sessionScope.customer}">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Personal Information</h5>
        <p class="card-text"><strong>Name:</strong> <c:out value="${sessionScope.customer.name}"/></p>
        <p class="card-text"><strong>Email:</strong> <c:out value="${sessionScope.customer.email}"/></p>
        <p class="card-text"><strong>Phone:</strong> <c:out value="${sessionScope.customer.phone}"/></p>
        <p class="card-text"><strong>Address:</strong> <c:out value="${sessionScope.customer.address}"/></p>
        <p class="card-text"><strong>Gender:</strong> <c:out value="${sessionScope.customer.gender}"/></p>
        <p class="card-text"><strong>Status:</strong> <c:out value="${sessionScope.customer.status}"/></p>

        <!-- Edit Profile Button -->
        <a href="${pageContext.request.contextPath}/customer/edit-profile" class="btn btn-primary mt-3">Edit Profile</a>
        <a href="${pageContext.request.contextPath}/customer/logout" class="btn btn-danger mt-3">Logout</a>
      </div>
    </div>
  </c:if>

  <!-- If customer not found -->
  <c:if test="${empty sessionScope.customer}">
    <p class="text-danger">Customer not found.</p>
  </c:if>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
