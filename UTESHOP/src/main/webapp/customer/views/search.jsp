<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <title>Search Results</title>
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Search Results for "<c:out value="${keyword}"/>"</h1>
    <div class="row">
        <c:forEach var="product" items="${productList}">
            <div class="col-md-4 mb-4">
                <div class="card h-100">
                    <c:if test="${not empty product.productImages}">
                        <img src="${product.productImages[0].productImage}" class="card-img-top" alt="${product.name}">
                    </c:if>
                    <div class="card-body">
                        <h5 class="card-title"><c:out value="${product.name}"/></h5>
                        <p class="card-text"><c:out value="${product.descript}"/></p>
                        <p class="card-text text-muted">Price: $<c:out value="${product.price}"/></p>
                        <p class="card-text text-muted">Weight: <c:out value="${product.weight}"/> kg</p>
                        <a href="${pageContext.request.contextPath}/product-detail?productId=${product.productId}" class="btn btn-primary">View Product</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li class="page-item <c:if test='${page == 1}'>disabled</c:if>'">
                <a class="page-link" href="${pageContext.request.contextPath}/search?keyword=${keyword}&page=${page - 1}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach begin="1" end="${totalPages}" var="i">
                <li class="page-item <c:if test='${i == page}'>active</c:if>'"><a class="page-link" href="${pageContext.request.contextPath}/search?keyword=${keyword}&page=${i}">${i}</a></li>
            </c:forEach>
            <li class="page-item <c:if test='${page == totalPages}'>disabled</c:if>'">
                <a class="page-link" href="${pageContext.request.contextPath}/search?keyword=${keyword}&page=${page + 1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
