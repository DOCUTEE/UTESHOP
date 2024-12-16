<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Edit Vendor</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
<div class="container my-5">
  <h1 class="mb-4">Edit Vendor</h1>
  <!-- Check if vendor exists -->
  <c:if test="${not empty vendor}">
    <form action="${pageContext.request.contextPath}/admin/edit-vendor" method="post">
      <input type="hidden" name="id" value="${vendor.vendorId}">
      <div class="mb-3">
        <label for="name" class="form-label">Name</label>
        <input type="text" name="name" id="name" class="form-control" value="${vendor.name}" required>
      </div>
      <div class="mb-3">
        <label for="email" class="form-label">Email</label>
        <input type="email" name="email" id="email" class="form-control" value="${vendor.email}" required>
      </div>
      <div class="mb-3">
        <label for="password" class="form-label">Password</label>
        <input type="password" name="password" id="password" class="form-control" value="${vendor.password}" required>
      </div>
      <div class="mb-3">
        <label for="phone" class="form-label">Phone</label>
        <input type="text" name="phone" id="phone" class="form-control" value="${vendor.phone}" required>
      </div>
      <div class="mb-3">
        <label for="address" class="form-label">Address</label>
        <input type="text" name="address" id="address" class="form-control" value="${vendor.address}" required>
      </div>
      <div class="mb-3">
        <label for="gender" class="form-label">Gender</label>
        <select name="gender" id="gender" class="form-control" required>
          <option value="Male" ${vendor.gender == 'Male' ? 'selected' : ''}>Male</option>
          <option value="Female" ${vendor.gender == 'Female' ? 'selected' : ''}>Female</option>
          <option value="Other" ${vendor.gender == 'Other' ? 'selected' : ''}>Other</option>
        </select>
      </div>
      <div class="mb-3">
        <label for="status" class="form-label">Status</label>
        <input type="text" name="status" id="status" class="form-control" value="${vendor.status}" required>
      </div>
      <div class="mb-3">
        <label for="isDelete" class="form-label">Is Delete</label>
        <select name="isDelete" id="isDelete" class="form-control" required>
          <option value="true" ${vendor.isDelete ? 'selected' : ''}>Yes</option>
          <option value="false" ${!vendor.isDelete ? 'selected' : ''}>No</option>
        </select>
      </div>
      <button type="submit" class="btn btn-primary">Save Changes</button>
    </form>
  </c:if>

  <!-- If vendor not found -->
  <c:if test="${empty vendor}">
    <p class="text-danger">Vendor not found.</p>
  </c:if>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
