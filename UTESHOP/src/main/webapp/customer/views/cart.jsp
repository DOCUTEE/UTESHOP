<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shopping Cart</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
<div class="container my-5">
    <h1 class="mb-4">Shopping Cart</h1>

    <!-- Check if cart exists and has items -->
    <c:if test="${not empty cart && not empty cart.cartItems}">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Product</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Total</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="cartItem" items="${cart.cartItems}">
                <tr>
                    <td>
                        <img src="${cartItem.product.productImages[0].productImage}" alt="${cartItem.product.name}" class="img-thumbnail" style="width: 100px; height: 100px;">
                        <div>${cartItem.product.name}</div>
                    </td>
                    <td>${cartItem.quantity}</td>
                    <td><c:out value="${cartItem.product.price}"/>VND</td>
                    <td><c:out value="${cartItem.price}"/>VND</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/remove-from-cart" method="post" class="d-inline">
                            <input type="hidden" name="cartItemId" value="${cartItem.cartItemId}">
                            <button type="submit" class="btn btn-danger btn-sm">Remove</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div class="text-end">
            <a href="${pageContext.request.contextPath}/checkout" class="btn btn-success">Proceed to Checkout</a>
        </div>
    </c:if>

    <!-- If cart is empty -->
    <c:if test="${empty cart || empty cart.cartItems}">
        <p>Your cart is empty. <a href="${pageContext.request.contextPath}/home">Continue shopping</a></p>
    </c:if>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
