<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Product Detail</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
<div class="container my-5">
  <!-- Product Details Header -->
  <h1 class="mb-4">Product Details</h1>

  <!-- Check if product exists -->
  <c:if test="${not empty product}">
    <div class="row">
      <!-- Product Images -->
      <div class="col-md-5">
        <c:if test="${not empty product.productImages}">
          <div id="carouselProductImages" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner">
              <c:set var="firstImage" value="${product.productImages[0]}"/>
              <div class="carousel-item active">
                <img src="${firstImage.productImage}" class="d-block w-100" alt="Product Image">
              </div>
            </div>
          </div>
        </c:if>
      </div>

      <!-- Product Info -->
      <div class="col-md-7">
        <h2>${product.name}</h2>
        <p><strong>Category:</strong> ${product.category.categoryName}</p>
        <p><strong>Vendor:</strong> ${product.vendor.name}</p>

        <p class="text-success"><strong>Price:</strong> $<c:out value="${product.price}"/></p>
        <p><strong>Quantity:</strong> <c:out value="${product.quantity}"/> available</p>
        <p><strong>Weight:</strong> <c:out value="${product.weight}"/> kg</p>

        <p><strong>Description:</strong></p>
        <p><c:out value="${product.descript}"/></p>

        <!-- Add to Cart Button -->
        <form action="/add-to-cart" method="post">
          <input type="hidden" name="productId" value="${product.productId}">
          <button type="submit" class="btn btn-primary">Add to Cart</button>
        </form>
      </div>

    </div>

    <!-- Product Reviews -->
    <div class="mt-5">
      <h3>Reviews</h3>
      <c:if test="${not empty product.reviews}">
        <ul class="list-group">
          <c:forEach var="review" items="${product.reviews}">
            <li class="list-group-item">
              <strong>${review.Customer.name}</strong>: ${review.content} <br>
              <small class="text-muted">Rating: ${review.rating}/5</small>
            </li>
          </c:forEach>
        </ul>
      </c:if>
      <c:if test="${empty product.reviews}">
        <p>No reviews yet. Be the first to leave a review!</p>
      </c:if>
    </div>
  </c:if>

  <!-- Product Not Found -->
  <c:if test="${empty product}">
    <p class="text-danger">Product not found.</p>
  </c:if>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
