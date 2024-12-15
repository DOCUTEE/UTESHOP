<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <title>Product Management</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
  <h1 class="text-center">Product Management</h1>

  <div class="col-auto">
    <button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addProductModal">Add New Product</button>
  </div>

  <!-- Product List Table -->
  <table class="table table-bordered table-hover mt-3">
    <thead class="table-dark">
    <tr>
      <th>Product ID</th>
      <th>Product Name</th>
      <th>Description</th>
      <th>Price</th>
      <th>Quantity</th>
      <th>Weight</th>
      <th>Is Deleted</th>
      <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <!-- Using c:forEach to iterate through the product list -->
    <c:forEach var="product" items="${listProduct}">
      <tr>
        <td>${product.productId}</td>
        <td>${product.name}</td>
        <td>${product.descript}</td>
        <td>${product.price}</td>
        <td>${product.quantity}</td>
        <td>${product.weight}</td>
        <td>${product.isDelete ? 'Yes' : 'No'}</td>
        <td>
          <button class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#editProductModal"
                  onclick="fillEditModal(${product.productId}, '${product.name}', '${product.descript}', ${product.price}, ${product.quantity}, ${product.weight}, ${product.isDelete})">
            Edit
          </button>
          <form action="product/delete" method="post" class="d-inline">
            <input type="hidden" name="productId" value="${product.productId}">
            <button type="submit" class="btn btn-danger btn-sm">Delete</button>
          </form>
        </td>
      </tr>
    </c:forEach>
    <!-- Display message if the product list is empty -->
    <c:if test="${empty listProduct}">
      <tr>
        <td colspan="8" class="text-center">No products available!</td>
      </tr>
    </c:if>
    </tbody>
  </table>

  <!-- Button to open the modal -->
  <div class="col-auto">
    <button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addProductModal">Add New Product</button>
  </div>

  <div class="container mt-3">
    <div class="row justify-content-center">
      <!-- Back to home page -->
      <div class="col-auto">
        <a href="home" class="btn btn-primary">Back to Home</a>
      </div>
    </div>
  </div>
</div>

<!-- Add Product Modal -->
<div class="modal fade" id="addProductModal" tabindex="-1" aria-labelledby="addProductModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="addProductModalLabel">Add New Product</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <!-- Form to add a new product -->
        <form action="product/addproduct" method="post" enctype="multipart/form-data">
          <div class="mb-3">
            <label class="form-label">Product Name</label>
            <input type="text" class="form-control" name="productName" required>
          </div>
          <div class="mb-3">
            <label class="form-label">Description</label>
            <textarea class="form-control" name="description"></textarea>
          </div>
          <div class="mb-3">
            <label class="form-label">Price</label>
            <input type="number" step="0.01" class="form-control" name="price" required>
          </div>
          <div class="mb-3">
            <label class="form-label">Quantity</label>
            <input type="number" class="form-control" name="quantity" required>
          </div>
          <div class="mb-3">
            <label class="form-label">Weight</label>
            <input type="number" step="0.01" class="form-control" name="weight">
          </div>
          <div class="mb-3">
            <label class="form-label">Is Deleted</label>
            <select class="form-select" name="isDelete">
              <option value="false">No</option>
              <option value="true">Yes</option>
            </select>
          </div>
          <button type="submit" class="btn btn-primary">Add Product</button>
        </form>
      </div>
    </div>
  </div>
</div>

<!-- Edit Product Modal -->
<div class="modal fade" id="editProductModal" tabindex="-1" aria-labelledby="editProductModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="editProductModalLabel">Edit Product</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <!-- Form to edit a product -->
        <form action="product/editproduct" method="post" enctype="multipart/form-data">
          <input type="hidden" name="productId" id="editProductId">
          <div class="mb-3">
            <label class="form-label">Product Name</label>
            <input type="text" class="form-control" name="productName" id="editProductName" required>
          </div>
          <div class="mb-3">
            <label class="form-label">Description</label>
            <textarea class="form-control" name="description" id="editDescription"></textarea>
          </div>
          <div class="mb-3">
            <label class="form-label">Price</label>
            <input type="number" step="0.01" class="form-control" name="price" id="editPrice" required>
          </div>
          <div class="mb-3">
            <label class="form-label">Quantity</label>
            <input type="number" class="form-control" name="quantity" id="editQuantity" required>
          </div>
          <div class="mb-3">
            <label class="form-label">Weight</label>
            <input type="number" step="0.01" class="form-control" name="weight" id="editWeight">
          </div>
          <div class="mb-3">
            <label class="form-label">Is Deleted</label>
            <select class="form-select" name="isDelete" id="editIsDelete">
              <option value="false">No</option>
              <option value="true">Yes</option>
            </select>
          </div>
          <button type="submit" class="btn btn-primary">Save Changes</button>
        </form>
      </div>
    </div>
  </div>
</div>

<!-- Bootstrap JS and Popper.js (required for modal functionality) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script>
  function fillEditModal(productId, name, descript, price, quantity, weight, isDelete) {
    document.getElementById('editProductId').value = productId;
    document.getElementById('editProductName').value = name;
    document.getElementById('editDescription').value = descript;
    document.getElementById('editPrice').value = price;
    document.getElementById('editQuantity').value = quantity;
    document.getElementById('editWeight').value = weight;
    document.getElementById('editIsDelete').value = isDelete;
  }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
