<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="ktweb.uteshop.entity.Vendor" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Vendors</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .vendor-link {
            cursor: pointer;
            color: blue;
            text-decoration: underline;
        }
    </style>
    <script>
        function selectVendor(vendorId) {
            alert("Vendor ID: " + vendorId);
        }
    </script>
</head>
<body>
    <div class="container">
        <div class="header text-center bg-light py-3">
            <h1>Manage Vendors</h1>
        </div>

        <div class="content my-4">
            <form action="${pageContext.request.contextPath}/admin/shop" method="get" class="search-form form-inline mb-3">
                <label for="keyword" class="mr-2">Search:</label>
                <input type="text" id="keyword" name="keyword" class="form-control mr-2" value="<%= request.getParameter("keyword") %>" />
                <button type="submit" class="btn btn-primary">Search</button>
            </form>

            <%
                List<Vendor> vendorList = (List<Vendor>) request.getAttribute("vendorList");
                Integer currentPage = (Integer) request.getAttribute("currentPage");
                Integer totalPages = (Integer) request.getAttribute("totalPages");
                if (vendorList != null && !vendorList.isEmpty()) {
                    %>
                    <table class="table table-bordered table-hover">
                        <thead class="thead-light">
                            <tr>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>Address</th>
                                <th>Select</th>
                            </tr>
                        </thead>
                        <tbody>
                        <%
                        for (Vendor vendor : vendorList) {
                            %>
                            <tr>
                                <td><%= vendor.getName() %></td>
                                <td><%= vendor.getEmail() %></td>
                                <td><%= vendor.getPhone() %></td>
                                <td><%= vendor.getAddress() %></td>
                                <td><a class="vendor-link" href="javascript:void(0);" onclick="selectVendor(<%= vendor.getVendorId() %>)">Select</a></td>
                            </tr>
                            <%
                        }
                        %>
                        <tr>
                            <td colspan="5" class="pagination text-center">
                                Page: <%= currentPage %> of <%= totalPages %>
                                <%
                                if (currentPage != null && totalPages != null) {
                                    for (int i = 1; i <= totalPages; i++) {
                                        if (i == currentPage) {
                                            %>
                                            <span class="badge badge-primary"><%= i %></span>
                                            <%
                                        } else {
                                            %>
                                            <a href="${pageContext.request.contextPath}/admin/shop?keyword=<%= request.getParameter("keyword") %>&page=<%= i %>" class="badge badge-light"><%= i %></a>
                                            <%
                                        }
                                    }
                                }
                                %>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <%
                } else {
                    %>
                    <p class="text-danger">No vendors found.</p>
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
