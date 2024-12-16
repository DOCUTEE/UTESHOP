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
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <style>
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
        <div class="header text-center bg-light py-3">
            <h1>Manage Products</h1>
        </div>

        <div class="content my-4">
            <form action="${pageContext.request.contextPath}/admin/shop/product" method="get" class="search-form form-inline mb-3">
                <label for="keyword" class="mr-2">Search:</label>
                <input type="text" id="keyword" name="keyword" class="form-control mr-2" value="<%= request.getParameter("keyword") %>" />
                <label for="vendorId" class="mr-2">Vendor ID:</label>
                <input type="number" id="vendorId" name="vendorId" class="form-control mr-2" value="<%= request.getParameter("vendorId") %>" />
                <button type="submit" class="btn btn-primary">Search</button>
            </form>

            <%
                List<Product> productList = (List<Product>) request.getAttribute("productList");
                Integer currentPage = (Integer) request.getAttribute("currentPage");
                Integer totalPages = (Integer) request.getAttribute("totalPages");
                if (productList != null && !productList.isEmpty()) {
                    %>
                    <table class="table table-bordered table-hover">
                        <thead class="thead-light">
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
                        </thead>
                        <tbody>
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
                                <td><a class="product-link" href="javascript:void(0);" onclick="selectProduct(<%= product.getProductId() %>)">Select</a></td>
                            </tr>
                            <%
                        }
                        %>
                        <tr>
                            <td colspan="8" class="text-center">
                                <nav>
                                    <ul class="pagination justify-content-center">
                                        <%
                                        if (currentPage != null && totalPages != null) {
                                            for (int i = 1; i <= totalPages; i++) {
                                                if (i == currentPage) {
                                                    %>
                                                    <li class="page-item active"><span class="page-link"><%= i %></span></li>
                                                    <%
                                                } else {
                                                    %>
                                                    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/admin/shop/product?keyword=<%= request.getParameter("keyword") %>&vendorId=<%= request.getParameter("vendorId") %>&page=<%= i %>"><%= i %></a></li>
                                                    <%
                                                }
                                            }
                                        }
                                        %>
                                    </ul>
                                </nav>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <%
                } else {
                    %>
                    <p class="text-danger">No products found.</p>
                    <%
                }
            %>
        </div>

        <div class="footer bg-light text-center py-3">
            <p>&copy; 2024 Our Shop. All rights reserved.</p>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
