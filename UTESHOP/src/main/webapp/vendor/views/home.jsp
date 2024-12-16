<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--import Java.utils.list--%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Vendor Home</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<!-- Navigation Bar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Vendor Dashboard</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav ms-auto">
        <li class="nav-item">
          <a class="nav-link" href="<%= request.getContextPath() %>/vendor/logout">Logout</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<!-- Page Content -->
<div class="container my-4">
  <h1 class="mb-4">Welcome, <%= ((ktweb.uteshop.entity.Vendor) request.getSession().getAttribute("vendor")).getName() %>!</h1>
  <a href="${pageContext.request.contextPath}/vendor/product/add" class="btn btn-success mb-3">Add Product</a>
  <!-- Product Table -->
  <div class="card shadow">
    <div class="card-header bg-primary text-white">
      <h4>Products</h4>
    </div>
    <div class="card-body">
      <table class="table table-striped">
        <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Product Name</th>
          <th scope="col">Price</th>
          <th scope="col">Quantity</th>
          <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
          List<ktweb.uteshop.entity.Product> products = (List<ktweb.uteshop.entity.Product>) request.getAttribute("products");
          if (products != null && !products.isEmpty()) {
            int index = 1;
            for (ktweb.uteshop.entity.Product product : products) {
        %>
        <tr>
          <th scope="row"><%= index++ %></th>
          <td><%= product.getName() %></td>
          <td>$<%= product.getPrice() %></td>
          <td><%= product.getQuantity() %></td>
          <td>
            <a href="<%= request.getContextPath() %>/vendor/product/edit?id=<%= product.getProductId() %>" class="btn btn-warning btn-sm">Edit</a>
            <a href="<%= request.getContextPath() %>/vendor/product/delete?id=<%= product.getProductId() %>" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this product?');">Delete</a>
          </td>
        </tr>
        <%
          }
        } else {
        %>
        <tr>
          <td colspan="5" class="text-center">No products found.</td>
        </tr>
        <% } %>
        </tbody>
      </table>
    </div>
  </div>

  <!-- Pagination -->
  <nav class="mt-4">
    <ul class="pagination justify-content-center">
      <%
        int currentPage = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
        if (currentPage > 1) {
      %>
      <li class="page-item">
        <a class="page-link" href="?page=<%= currentPage - 1 %>">Previous</a>
      </li>
      <% } %>
      <li class="page-item">
        <a class="page-link" href="?page=<%= currentPage + 1 %>">Next</a>
      </li>
    </ul>
  </nav>
</div>

<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
