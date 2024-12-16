package ktweb.uteshop.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ktweb.uteshop.entity.Order;
import ktweb.uteshop.service.implement.OrderServiceImpl;
import ktweb.uteshop.service.interfaces.IOrderService;

import java.io.IOException;

@WebServlet(name = "ViewOrderController", value = "/admin/view-order")
public class AdminViewOrderController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IOrderService orderService = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null) {
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return;
        }

        int orderId = Integer.parseInt(request.getParameter("id"));
        Order order = orderService.findById(orderId);
        request.setAttribute("order", order);
        request.getRequestDispatcher("/admin/views/viewOrder.jsp").forward(request, response);
    }
}
