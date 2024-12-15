<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="ktweb.uteshop.entity.Product" %>
<%@ page import="ktweb.uteshop.entity.Category" %>
<%@ page import="ktweb.uteshop.entity.Vendor" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Products</title>
</head>
<body>
    <h1>Search Products</h1>
    <form action="search" method="get">
        <label for="keyword">Enter keyword:</label>
        <input type="text" id="keyword" name="keyword" value="<%= request.getParameter("keyword") %>" required>
        <input type="submit" value="Search">
    </form>

    <%
        String keyword = request.getParameter("keyword");
        if (keyword != null && !keyword.trim().isEmpty()) {
            List<Product> productList = (List<Product>) request.getAttribute("productList");
            Integer currentPage = (Integer) request.getAttribute("currentPage");
            Integer totalPages = (Integer) request.getAttribute("totalPages");

            if (productList != null && !productList.isEmpty()) {
                %>
                <h2>Search Results for: <%= keyword %></h2>
                <table border='1'>
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Description</th>
                        <th>Quantity</th>
                        <th>Weight</th>
                        <th>Category</th>
                        <th>Vendor</th>
                    </tr>
                    <%
                    for (Product product : productList) {
                        %>
                        <tr>
                            <td><%= product.getName() %></td>
                            <td><%= product.getPrice() %></td>
                            <td><%= product.getDescript() %></td>
                            <td><%= product.getQuantity() %></td>
                            <td><%= product.getWeight() %></td>
                            <td><%= product.getCategory() != null ? product.getCategory().getCategoryName() : "N/A" %></td>
                            <td><%= product.getVendor() != null ? product.getVendor().getName() : "N/A" %></td>
                        </tr>
                        <%
                    }
                    %>
                </table>
                <%
            } else {
                %>
                <h2>No results found for: <%= keyword %></h2>
                <%
            }

            if (totalPages != null && totalPages > 1) {
                %>
                <div>
                    Page: <%= currentPage %> of <%= totalPages %>
                    <%
                    for (int i = 1; i <= totalPages; i++) {
                        if (i == currentPage) {
                            %>
                            <strong><%= i %></strong>
                            <%
                        } else {
                            %>
                            <a href="search?keyword=<%= keyword %>&page=<%= i %>"><%= i %></a>
                            <%
                        }
                    }
                    %>
                </div>
                <%
            }
        }
    %>
</body>
</html>
