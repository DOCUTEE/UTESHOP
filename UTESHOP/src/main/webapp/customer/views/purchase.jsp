<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="ktweb.uteshop.entity.Order" %>
<%@ page import="ktweb.uteshop.entity.OrderItem" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Purchase</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="text-center my-4">Order Confirmation</h1>

        <%
            Order order = (Order) request.getAttribute("order");
            if (order != null) {
                %>
                <div class="card mb-4">
                    <div class="card-body">
                        <h2 class="card-title">Order ID: <%= order.getOrderId() %></h2>
                        <p class="card-text">Order Date: <%= order.getOrderDate() %></p>
                        <p class="card-text">Status: <%= order.getStatus() %></p>
                        <p class="card-text">Total Cost: <%= order.getTotalCost() %></p>
                        <p class="card-text">Discount: <%= order.getDiscount() %></p>
                        <p class="card-text">Actual Cost: <%= order.getActualCost() %></p>
                    </div>
                </div>
                
                <div class="card mb-4">
                    <div class="card-body">
                        <h3 class="card-title">Shipping Information</h3>
                        <p class="card-text">City/Province: <%= order.getCityOfProvince() %></p>
                        <p class="card-text">District: <%= order.getDistrict() %></p>
                        <p class="card-text">Ward: <%= order.getWard() %></p>
                        <p class="card-text">Street Number: <%= order.getStreetNumber() %></p>
                        <p class="card-text">Phone: <%= order.getPhone() %></p>
                    </div>
                </div>

                <h3>Order Items</h3>
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
                    for (OrderItem orderItem : order.getOrderItems()) {
                        double total = orderItem.getQuantity() * orderItem.getPrice();
                        grandTotal += total;
                        %>
                        <tr>
                            <td><%= orderItem.getProduct().getName() %></td>
                            <td><%= orderItem.getQuantity() %></td>
                            <td><%= orderItem.getPrice() %></td>
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
                <h2 class="text-center text-danger">No order information available.</h2>
                <%
            }
        %>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
