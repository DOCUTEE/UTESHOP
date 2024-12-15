<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="ktweb.uteshop.entity.Product" %>
<%@ page import="ktweb.uteshop.entity.Vendor" %>
<%@ page import="ktweb.uteshop.entity.Category" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Products</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            width: 80%;
            margin: 0 auto;
        }
        .header, .footer {
            background-color: #f8f8f8;
            padding: 20px;
            text-align: center;
        }
        .content {
            margin: 20px 0;
        }
        .search-form {
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid #ccc;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        .pagination {
            margin-top: 20px;
        }
        .pagination a, .pagination span {
            margin: 0 5px;
            text-decoration: none;
        }
        .product-link {
            cursor: pointer;
            color: blue;
            text-decoration: underline;
        }
    </style>
    <script>
        function selectProduct(productId) {
            alert("Product ID: " + productId);
        }
    </script>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Manage Products</h1>
        </div>

        <div class="content">
            <form action="/admin/shop/product" method="get" class="search-form">
                <label for="keyword">Search:</label>
                <input type="text" id="keyword" name="keyword" value="<%= request.getParameter("keyword") %>" />
                <label for="vendorId">Vendor ID:</label>
                <input type="number" id="vendorId" name="vendorId" value="<%= request.getParameter("vendorId") %>" />
                <button type="submit">Search</button>
            </form>

            <%
                List<Product> productList = (List<Product>) request.getAttribute("productList");
                Integer currentPage = (Integer) request.getAttribute("currentPage");
                Integer totalPages = (Integer) request.getAttribute("totalPages");
                if (productList != null && !productList.isEmpty()) {
                    %>
                    <table>
                        <tr>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Weight</th>
                            <th>Category</th>
                            <th>Vendor</th>
                            <th>Select</th>
                        </tr>
                        <%
                        for (Product product : productList) {
                            %>
                            <tr>
                                <td class="product-link" onclick="selectProduct(<%= product.getProductId() %>)"><%= product.getName() %></td>
                                <td><%= product.getDescript() %></td>
                                <td><%= product.getPrice() %></td>
                                <td><%= product.getQuantity() %></td>
                                <td><%= product.getWeight() %></td>
                                <td><%= product.getCategory().getCategoryName() %></td>
                                <td><%= product.getVendor().getName() %></td>
                                <td><a class="product-link" onclick="selectProduct(<%= product.getProductId() %>)">Select</a></td>
                            </tr>
                            <%
                        }
                        %>
                    </table>
                    <div class="pagination">
                        Page: <%= currentPage %> of <%= totalPages %>
                        <%
                        for (int i = 1; i <= totalPages; i++) {
                            if (i == currentPage) {
                                %>
                                <span><%= i %></span>
                                <%
                            } else {
                                %>
                                <a href="/admin/shop/product?keyword=<%= request.getParameter("keyword") %>&vendorId=<%= request.getParameter("vendorId") %>&page=<%= i %>"><%= i %></a>
                                <%
                            }
                        }
                        %>
                    </div>
                    <%
                } else {
                    %>
                    <p>No products found.</p>
                    <%
                }
            %>
        </div>

        <div class="footer">
            <p>&copy; 2024 Our Shop. All rights reserved.</p>
        </div>
    </div>
</body>
</html>
