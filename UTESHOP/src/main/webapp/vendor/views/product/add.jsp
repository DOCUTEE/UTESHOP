<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container my-5">
    <h2>Add New Product</h2>

    <%-- Hiển thị thông báo --%>
    <c:if test="${not empty message}">
        <div class="alert <c:out value="${message.startsWith('Error') ? 'alert-danger' : 'alert-success'}" />">
                ${message}
        </div>
    </c:if>

    <form action="${pageContext.request.contextPath}/vendor/product/add" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Product Name</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>

        <div class="mb-3">
            <label for="descript" class="form-label">Description</label>
            <textarea class="form-control" id="descript" name="descript" rows="3"></textarea>
        </div>

        <div class="mb-3">
            <label for="quantity" class="form-label">Quantity</label>
            <input type="number" class="form-control" id="quantity" name="quantity" required>
        </div>

        <div class="mb-3">
            <label for="price" class="form-label">Price</label>
            <input type="number" step="0.01" class="form-control" id="price" name="price" required>
        </div>

        <div class="mb-3">
            <label for="weight" class="form-label">Weight</label>
            <input type="number" step="0.01" class="form-control" id="weight" name="weight" required>
        </div>

        <div class="mb-3">
            <label for="categoryId" class="form-label">Category</label>
            <select class="form-control" id="categoryId" name="categoryId" required>
                <c:forEach var="category" items="${categories}">
                    <option value="${category.categoryId}">${category.categoryName}</option>
                </c:forEach>
            </select>
        </div>

        <div class="mb-3">
            <label for="productImages" class="form-label">Product Images</label>
            <input type="text" class="form-control mb-2" id="productImages" name="productImages" placeholder="Image URL">
            <input type="text" class="form-control mb-2" name="productImages" placeholder="Image URL">
            <input type="text" class="form-control" name="productImages" placeholder="Image URL">
        </div>

        <button type="submit" class="btn btn-primary">Add Product</button>
        <a href="${pageContext.request.contextPath}/vendor/home" class="btn btn-secondary">Cancel</a>
    </form>
</div>
</body>
</html>
