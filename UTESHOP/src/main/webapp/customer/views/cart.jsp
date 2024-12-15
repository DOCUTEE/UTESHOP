<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="ktweb.uteshop.entity.CartItem" %>
<%@ page import="ktweb.uteshop.entity.Product" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cart</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="text-center my-4">Your Cart</h1>

        <%
            List<CartItem> cartItems = (List<CartItem>) request.getAttribute("cartItems");
            if (cartItems != null && !cartItems.isEmpty()) {
                %>
                <table class="table table-bordered table-hover">
                    <thead class="thead-light">
                        <tr>
                            <th>Product Name</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Total</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                    double grandTotal = 0;
                    for (CartItem cartItem : cartItems) {
                        Product product = cartItem.getProduct();
                        double total = cartItem.getQuantity() * cartItem.getPrice();
                        grandTotal += total;
                        %>
                        <tr>
                            <td><%= product.getName() %></td>
                            <td><%= cartItem.getQuantity() %></td>
                            <td><%= cartItem.getPrice() %></td>
                            <td><%= total %></td>
                        </tr>
                        <%
                    }
                    %>
                    <tr>
                        <td colspan="3" class="text-right"><strong>Grand Total</strong></td>
                        <td><%= grandTotal %></td>
                    </tr>
                    </tbody>
                </table>
                <%
            } else {
                %>
                <h2 class="text-center text-danger">Your cart is empty.</h2>
                <%
            }
        %>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
