package ktweb.uteshop.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ktweb.uteshop.entity.Order;
import ktweb.uteshop.entity.Vendor;
import ktweb.uteshop.service.implement.OrderServiceImpl;
import ktweb.uteshop.service.interfaces.IOrderService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminOrderController", value = "/admin/orders")
public class AdminOrderController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IOrderService orderService = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null) {
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return;
        }

        String keyword = request.getParameter("keyword");
        int page = 1;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        List<Order> orderList;
        if (keyword == null) {
            keyword = "";
        }
        orderList = orderService.findAllByPage(page, 10);
        request.setAttribute("orderList", orderList);
        request.setAttribute("currentPage", page);
        request.setAttribute("keyword", keyword);
        request.getRequestDispatcher("/admin/views/manageOrders.jsp").forward(request, response);
    }
}
