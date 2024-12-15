<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="ktweb.uteshop.entity.Vendor" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Vendors</title>
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
        .vendor-link {
            cursor: pointer;
            color: blue;
            text-decoration: underline;
        }
    </style>
    <script>
        function selectVendor(vendorId) {
            // Redirect to a specific page or perform an action with the vendorId
            alert("Vendor ID: " + vendorId);
        }
    </script>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Manage Vendors</h1>
        </div>

        <div class="content">
            <form action="/admin/shop" method="get" class="search-form">
                <label for="keyword">Search:</label>
                <input type="text" id="keyword" name="keyword" value="<%= request.getParameter("keyword") %>" />
                <button type="submit">Search</button>
            </form>

            <%
                List<Vendor> vendorList = (List<Vendor>) request.getAttribute("vendorList");
                Integer currentPage = (Integer) request.getAttribute("currentPage");
                Integer totalPages = (Integer) request.getAttribute("totalPages");
                if (vendorList != null && !vendorList.isEmpty()) {
                    %>
                    <table>
                        <tr>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Address</th>
                            <th>Select</th>
                        </tr>
                        <%
                        for (Vendor vendor : vendorList) {
                            %>
                            <tr>
                                <td><%= vendor.getName() %></td>
                                <td><%= vendor.getEmail() %></td>
                                <td><%= vendor.getPhone() %></td>
                                <td><%= vendor.getAddress() %></td>
                                <td><a class="vendor-link" onclick="selectVendor(<%= vendor.getVendorId() %>)">Select</a></td>
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
                                <a href="/admin/shop?keyword=<%= request.getParameter("keyword") %>&page=<%= i %>"><%= i %></a>
                                <%
                            }
                        }
                        %>
                    </div>
                    <%
                } else {
                    %>
                    <p>No vendors found.</p>
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
