<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
<div class="container my-5">
    <h1 class="mb-4">Checkout</h1>

    <!-- Check if cart exists and has items -->
    <c:if test="${not empty cart && not empty cart.cartItems}">
        <div class="row">
            <div class="col-md-8">
                <h3>Your Order</h3>
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
                    <c:set var="totalPrice" value="0"/>
                    <c:forEach var="cartItem" items="${cart.cartItems}">
                        <tr>
                            <td>${cartItem.product.name}</td>
                            <td>${cartItem.quantity}</td>
                            <td>$<c:out value="${cartItem.product.price}"/></td>
                            <td>$<c:out value="${cartItem.price}"/></td>
                        </tr>
                        <c:set var="totalPrice" value="${totalPrice + cartItem.price}"/>
                    </c:forEach>
                    </tbody>
                    <tfoot>
                    <tr>
                        <td colspan="3" class="text-end"><strong>Total:</strong></td>
                        <td><c:out value="${totalPrice}"/> VND</td>
                    </tr>
                    </tfoot>
                </table>
            </div>
            <div class="col-md-4">
                <h3>Shipping Details</h3>
                <form action="${pageContext.request.contextPath}/checkout" method="post">
                    <div class="mb-3">
                        <label for="cityOfProvince" class="form-label">City/Province</label>
                        <input type="text" name="cityOfProvince" id="cityOfProvince" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label for="district" class="form-label">District</label>
                        <input type="text" name="district" id="district" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label for="ward" class="form-label">Ward</label>
                        <input type="text" name="ward" id="ward" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label for="streetNumber" class="form-label">Street Number</label>
                        <input type="text" name="streetNumber" id="streetNumber" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label for="phone" class="form-label">Phone</label>
                        <input type="text" name="phone" id="phone" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label for="voucherCode" class="form-label">Voucher Code</label>
                        <input type="text" name="voucherCode" id="voucherCode" class="form-control">
                    </div>
                    <button type="submit" class="btn btn-primary">Place Order</button>
                </form>
            </div>
        </div>
    </c:if>

    <!-- If cart is empty -->
    <c:if test="${empty cart || empty cart.cartItems}">
        <p>Your cart is empty. <a href="${pageContext.request.contextPath}/shop">Continue shopping</a></p>
    </c:if>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
