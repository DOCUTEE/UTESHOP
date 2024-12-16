<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Register</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h2 class="text-center mb-4">Customer Register</h2>

            <!-- Hiển thị thông báo lỗi -->
            <c:if test="${not empty error}">
                <div class="alert alert-danger">${error}</div>
            </c:if>

            <!-- Form đăng ký -->
            <form action="${pageContext.request.contextPath}/customer/register" method="post">
                <div class="form-group">
                    <label for="name">Username</label>
                    <input type="text" class="form-control" id="name" name="name" value="${customer != null ? customer.name : ''}" placeholder="Nhập họ và tên" required>
                </div>

                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" name="email" value="${customer != null ? customer.email : ''}" placeholder="Nhập email" required>
                </div>

                <div class="form-group">
                    <label for="phonenumber">Số điện thoại</label>
                    <input type="text" class="form-control" id="phonenumber" name="phonenumber" value="${customer != null ? customer.phone : ''}" placeholder="Nhập số điện thoại" required>
                </div>

                <div class="form-group">
                    <label for="password">Mật khẩu</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Nhập mật khẩu" required>
                </div>

                <button type="submit" class="btn btn-primary btn-block mt-3">Register</button>
            </form>

            <div class="text-center mt-3">
                <p>Đã có tài khoản? <a href="${pageContext.request.contextPath}/customer/login">Sign in</a></p>
            </div>
        </div>
    </div>
</div>
</body>

</html>
