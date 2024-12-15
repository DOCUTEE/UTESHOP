package ktweb.uteshop.controller.customer;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import ktweb.uteshop.entity.Customer;
import ktweb.uteshop.service.implement.OrderServiceImpl;
import ktweb.uteshop.service.interfaces.IOrderService;

import java.io.IOException;

@WebServlet(name = "PurchaseController", value = "/purchase")
public class PurchaseController extends HttpServlet {
        IOrderService orderService = new OrderServiceImpl();
        @Override
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
                try {
                        HttpSession session = request.getSession();
                        if (session.getAttribute("customer") == null) {
                                response.sendRedirect(request.getContextPath() + "/customer/login");
                                return;
                        }
                        if (session.getAttribute("cartId") == null) {
                                response.sendRedirect(request.getContextPath() + "customer/error");
                                return;
                        }
                        Integer customerId = ((Customer) session.getAttribute("customer")).getCustomerId();
                        if (request.getAttribute("order") == null) {
                                response.sendRedirect(request.getContextPath() + "/customer/error");
                                return;
                        }
                        request.setAttribute("order", orderService.findById((Integer) request.getAttribute("order")));
                        request.getRequestDispatcher("/customer/views/purchase.jsp").forward(request, response);
                }
                catch (Exception ex) {
                        ex.printStackTrace();
                        response.sendRedirect(request.getContextPath() + "/customer/error");
                }
        }
}
