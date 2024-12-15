<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="ktweb.uteshop.entity.Order" %>
<%@ page import="ktweb.uteshop.entity.OrderItem" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Success</title>
</head>
<body>
    <h1>Order Success</h1>

    <%
        Order order = (Order) request.getAttribute("order");
        if (order != null) {
            %>
            <h2>Order ID: <%= order.getOrderId() %></h2>
            <p>Order Date: <%= order.getOrderDate() %></p>
            <p>Status: <%= order.getStatus() %></p>
            <p>Total Cost: <%= order.getTotalCost() %></p>
            <p>Discount: <%= order.getDiscount() %></p>
            <p>Actual Cost: <%= order.getActualCost() %></p>
            
            <h3>Shipping Information</h3>
            <p>City/Province: <%= order.getCityOfProvince() %></p>
            <p>District: <%= order.getDistrict() %></p>
            <p>Ward: <%= order.getWard() %></p>
            <p>Street Number: <%= order.getStreetNumber() %></p>
            <p>Phone: <%= order.getPhone() %></p>

            <h3>Order Items</h3>
            <table border='1'>
                <tr>
                    <th>Product Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Total</th>
                </tr>
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
                    <td colspan="3" align="right"><strong>Grand Total</strong></td>
                    <td><%= grandTotal %></td>
                </tr>
            </table>
            <%
        } else {
            %>
            <h2>No order information available.</h2>
            <%
        }
    %>
</body>
</html>
