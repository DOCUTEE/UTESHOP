<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Users</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
<div class="container my-5">
    <h1 class="mb-4">Manage Users</h1>

    <!-- Search Bar -->
    <form class="d-flex mb-4">
        <input class="form-control me-2" type="search" name="keyword" placeholder="Search by keyword" aria-label="Search" value="${param.keyword}">
        <button class="btn btn-outline-success" type="submit">Search</button>
    </form>

    <!-- Check if user list exists and is not empty -->
    <c:if test="${not empty userList}">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Address</th>
                <th>Gender</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${userList}">
                <tr>
                    <td>${user.customerId}</td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.phone}</td>
                    <td>${user.address}</td>
                    <td>${user.gender}</td>
                    <td>${user.status}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/edit-user?id=${user.customerId}" class="btn btn-primary btn-sm">Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/delete-user?id=${user.customerId}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this user?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <!-- Pagination -->
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li class="page-item <c:if test='${currentPage <= 1}'>disabled</c:if>'>
                    <a class="page-link" href="${pageContext.request.contextPath}/admin/users?keyword=${param.keyword}&page=${currentPage - 1}" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
                </a>
                </li>
                <c:forEach var="i" begin="1" end="${totalPages}">
                    <li class="page-item <c:if test='${i == currentPage}'>active</c:if>'>
                        <a class="page-link" href="${pageContext.request.contextPath}/admin/users?keyword=${param.keyword}&page=${i}">${i}</a>
                    </li>
                </c:forEach>
                <li class="page-item <c:if test='${currentPage >= totalPages}'>disabled</c:if>'>
                    <a class="page-link" href="${pageContext.request.contextPath}/admin/users?keyword=${param.keyword}&page=${currentPage + 1}" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
                </a>
                </li>
            </ul>
        </nav>
    </c:if>

    <!-- If user list is empty -->
    <c:if test="${empty userList}">
        <p>No users found. <a href="${pageContext.request.contextPath}/admin/users">Reload</a></p>
    </c:if>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
