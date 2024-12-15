package ktweb.uteshop.controller.customer;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import ktweb.uteshop.entity.Cart;
import ktweb.uteshop.entity.Customer;
import ktweb.uteshop.entity.Order;
import ktweb.uteshop.entity.Voucher;
import ktweb.uteshop.service.implement.CartServiceImpl;
import ktweb.uteshop.service.implement.OrderServiceImpl;
import ktweb.uteshop.service.implement.VoucherServiceImpl;
import ktweb.uteshop.service.interfaces.ICartService;
import ktweb.uteshop.service.interfaces.IOrderService;
import ktweb.uteshop.service.interfaces.IVoucherService;

import java.io.IOException;

@WebServlet(name = "CheckoutController", value = "/checkout")
public class CheckoutController extends HttpServlet {
        ICartService cartService = new CartServiceImpl();
        IVoucherService voucherService = new VoucherServiceImpl();
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
                        Cart cart = cartService.findByCustomerId(customerId);
                        request.setAttribute("cart", cart);
                        request.getRequestDispatcher("/customer/views/checkout.jsp").forward(request, response);
                }
                catch (Exception ex) {
                        ex.printStackTrace();
                        response.sendRedirect(request.getContextPath() + "/customer/error");
                }
        }
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
                        Cart cart = cartService.findByCustomerId(customerId);

                        Order order = new Order();
                        order.setDistrict(request.getParameter("district"));
                        order.setCityOfProvince(request.getParameter("cityOfProvince"));
                        order.setWard(request.getParameter("ward"));
                        order.setPhone(request.getParameter("phone"));
                        Voucher voucher = voucherService.findById(Integer.parseInt(request.getParameter("voucherId")));
                        order.setDiscount(voucher.getDiscount());

                        orderService.checkout(order, cart);

                        response.sendRedirect(request.getContextPath() + "/customer/purchase");
                }
                catch (Exception ex) {
                        ex.printStackTrace();
                        response.sendRedirect(request.getContextPath() + "/customer/error");
                }
        }
}
