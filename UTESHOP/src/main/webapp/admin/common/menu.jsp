<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Sidebar</title>
    <!-- Add Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/boxicons/2.0.7/css/boxicons.min.css" rel="stylesheet">
</head>
<body>
<aside id="layout-menu" class="col-md-2 bg-light sidebar py-3">
    <div class="main-logo text-center">
        <a href="${pageContext.request.contextPath}/home">
            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQU3Iu-JCuCrcWVV-wSXqYJlQygBoPPONNPhA&s"
                 alt="logo" class="img-fluid" width="100" height="100">
        </a>
    </div>
    <ul class="nav flex-column list-unstyled">
        <!-- Admin-specific items -->
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/admin/product" class="nav-link">
                <i class="menu-icon tf-icons bx bx-box"></i>
                <span>Manage Products</span>
            </a>
        </li>
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/admin/orders" class="nav-link">
                <i class="menu-icon tf-icons bx bx-cart"></i>
                <span>Manage Orders</span>
            </a>
        </li>

        <!-- Manage Vendors -->
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/admin/vendors" class="nav-link">
                <i class="menu-icon tf-icons bx bx-building"></i>
                <span>Manage Vendors</span>
            </a>
        </li>

        <!-- Manage Users -->
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/admin/users" class="nav-link">
                <i class="menu-icon tf-icons bx bx-user"></i>
                <span>Manage Users</span>
            </a>
        </li>

        <!-- Reports -->
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/admin/reports" class="nav-link">
                <i class="menu-icon tf-icons bx bx-line-chart"></i>
                <span>View Reports</span>
            </a>
        </li>

        <!-- Settings -->
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/admin/settings" class="nav-link">
                <i class="menu-icon tf-icons bx bx-cog"></i>
                <span>Settings</span>
            </a>
        </li>

        <!-- Logout Button -->
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/admin/logout" class="nav-link">
                <i class="menu-icon tf-icons bx bx-log-out"></i>
                <span>Logout</span>
            </a>
        </li>
    </ul>
</aside>

<!-- Add Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script>
    document.addEventListener('DOMContentLoaded', function () {
        // Highlight active menu item
        const menuItems = document.querySelectorAll('.nav-item');
        const currentUrl = window.location.pathname;
        menuItems.forEach(function (item) {
            const link = item.querySelector('a');
            if (link && currentUrl.startsWith(link.getAttribute('href'))) {
                item.classList.add('active');
            }
        });
    });
</script>
</body>
</html>
