<!-- menu.jsp -->
<aside id="layout-menu" class="col-md-2 bg-light sidebar py-3">
    <div class="main-logo">
        <a href="${pageContext.request.contextPath}/home">
            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQU3Iu-JCuCrcWVV-wSXqYJlQygBoPPONNPhA&s"
                 alt="logo" class="img-fluid" width="100" height="100">
        </a>

    </div>
    <ul class="menu-inner list-unstyled">
        <li class="menu-item">
            <a href="${pageContext.request.contextPath}/vendor/home" class="menu-link">
                <i class="menu-icon tf-icons bx bx-box"></i>
                <span>Manage product</span>
            </a>
        </li>
        <li class="menu-item">
            <a href="${pageContext.request.contextPath}/vendor/order" class="menu-link">
                <i class="menu-icon tf-icons bx bx-cart"></i>
                <span>Manage Orders</span>
            </a>
        </li>
    </ul>
</aside>

<script>
    document.addEventListener('DOMContentLoaded', function () {
        // Highlight active menu item
        const menuItems = document.querySelectorAll('.menu-item');
        const currentUrl = window.location.pathname;
        menuItems.forEach(function (item) {
            const link = item.querySelector('a');
            if (link && currentUrl.startsWith(link.getAttribute('href'))) {
                item.classList.add('active');
            }
        });
    });
</script>
