<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="ktweb.uteshop.entity.CartItem" %>
<%@ page import="ktweb.uteshop.entity.Product" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cart</title>
</head>
<body>
    <h1>Your Cart</h1>

    <%
        List<CartItem> cartItems = (List<CartItem>) request.getAttribute("cartItems");
        if (cartItems != null && !cartItems.isEmpty()) {
            %>
            <table border='1'>
                <tr>
                    <th>Product Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Total</th>
                </tr>
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
                    <td colspan="3" align="right"><strong>Grand Total</strong></td>
                    <td><%= grandTotal %></td>
                </tr>
            </table>
            <%
        } else {
            %>
            <h2>Your cart is empty.</h2>
            <%
        }
    %>
</body>
</html>
