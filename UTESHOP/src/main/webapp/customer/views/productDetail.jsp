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
              <c:forEach var="image" items="${product.productImages}" varStatus="status">
                <div class="carousel-item ${status.first ? 'active' : ''}">
                  <img src="${image.productImage}" class="d-block w-100" alt="Product Image">
                </div>
              </c:forEach>
            </div>
            <a class="carousel-control-prev" href="#carouselProductImages" role="button" data-bs-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselProductImages" role="button" data-bs-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Next</span>
            </a>
          </div>
        </c:if>
      </div>

      <!-- Product Info -->
      <div class="col-md-7">
        <h2>${product.name}</h2>
        <p><strong>Category:</strong> ${product.category.categoryName}</p>
        <p><strong>Vendor:</strong> ${product.vendor.name}</p>

        <p class="text-success"><strong>Price:</strong> <c:out value="${product.price}"/> VND</p>
        <p><strong>Quantity:</strong> <c:out value="${product.quantity}"/> available</p>
        <p><strong>Weight:</strong> <c:out value="${product.weight}"/> g</p>

        <p><strong>Description:</strong></p>
        <p><c:out value="${product.descript}"/></p>


        <!-- Add to Cart Button -->
        <form action="${pageContext.request.contextPath}/add-to-cart" method="post" class="mt-3">
          <input type="hidden" name="productId" value="${product.productId}">
          <div class="mb-3">
            <label for="quantity" class="form-label"><strong>Quantity:</strong></label>
            <input type="number" name="quantity" id="quantity" class="form-control" value="1" min="1" max="${product.quantity}" required>
          </div>
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
              <strong>${review.customer.name}</strong>: ${review.content} <br>
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
