<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Order Items</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
  <h1 class="mb-4">Order Items</h1>

  <table class="table table-striped">
    <thead>
    <tr>
      <th>#</th>
      <th>Order ID</th>
      <th>Order Date</th>
      <th>Status</th>
      <th>Product Name</th>
      <th>Quantity</th>
      <th>Price</th>
      <th>Total</th>
      <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
      <c:when test="${not empty orderItems}">
        <c:forEach var="item" items="${orderItems}" varStatus="status">
          <tr>
            <td>${status.index + 1}</td>
            <td>${item.order.orderId}</td>
            <td>${item.order.orderDate}</td>
            <td>${item.order.status}</td>
            <td>${item.product.name}</td>
            <td>${item.quantity}</td>
            <td>${item.product.price}</td>
            <td>${item.price}</td>
            <td>
              <button class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#orderDetailModal"
                      data-order-id="${item.order.orderId}"
                      data-city="${item.order.cityOfProvince}"
                      data-district="${item.order.district}"
                      data-ward="${item.order.ward}"
                      data-street="${item.order.streetNumber}"
                      data-phone="${item.order.phone}">
                View Details
              </button>
            </td>
          </tr>
        </c:forEach>
      </c:when>
      <c:otherwise>
        <tr>
          <td colspan="9" class="text-center">No order items found</td>
        </tr>
      </c:otherwise>
    </c:choose>
    </tbody>
  </table>

  <!-- Pagination -->
  <nav aria-label="Page navigation">
    <ul class="pagination justify-content-center">
      <li class="page-item">
        <a class="page-link" href="?page=${page - 1}" aria-disabled="${page <= 1}">Previous</a>
      </li>
      <li class="page-item disabled">
        <a class="page-link" href="#">Page ${page}</a>
      </li>
      <li class="page-item">
        <a class="page-link" href="?page=${page + 1}" aria-disabled="${orderItems.size() < pageSize}">Next</a>
      </li>
    </ul>
  </nav>
</div>

<!-- Modal -->
<div class="modal fade" id="orderDetailModal" tabindex="-1" aria-labelledby="orderDetailModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="orderDetailModalLabel">Shipping Details</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <p><strong>Order ID:</strong> <span id="modalOrderId"></span></p>
        <p><strong>City/Province:</strong> <span id="modalCity"></span></p>
        <p><strong>District:</strong> <span id="modalDistrict"></span></p>
        <p><strong>Ward:</strong> <span id="modalWard"></span></p>
        <p><strong>Street Number:</strong> <span id="modalStreet"></span></p>
        <p><strong>Phone:</strong> <span id="modalPhone"></span></p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
  const orderDetailModal = document.getElementById('orderDetailModal');
  orderDetailModal.addEventListener('show.bs.modal', function (event) {
    const button = event.relatedTarget;
    const orderId = button.getAttribute('data-order-id');
    const city = button.getAttribute('data-city');
    const district = button.getAttribute('data-district');
    const ward = button.getAttribute('data-ward');
    const street = button.getAttribute('data-street');
    const phone = button.getAttribute('data-phone');

    document.getElementById('modalOrderId').textContent = orderId;
    document.getElementById('modalCity').textContent = city;
    document.getElementById('modalDistrict').textContent = district;
    document.getElementById('modalWard').textContent = ward;
    document.getElementById('modalStreet').textContent = street;
    document.getElementById('modalPhone').textContent = phone;
  });
</script>
</body>
</html>
