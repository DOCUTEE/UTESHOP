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

                        Customer customer = ((Customer) session.getAttribute("customer"));
                        Cart cart = cartService.findByCustomerId(customer.getCustomerId());


                        Order order = new Order();
                        order.setCustomer(customer);
                        order.setDistrict(request.getParameter("district"));
                        order.setCityOfProvince(request.getParameter("cityOfProvince"));
                        order.setWard(request.getParameter("ward"));
                        order.setPhone(request.getParameter("phone"));
                        order.setStreetNumber(request.getParameter("streetNumber"));
                        order.setActualCost(0);
                        order.setTotalCost(0);

                        Voucher voucher = null;
                        String voucherCode = request.getParameter("voucherCode");
                        if (voucherCode != null) {
                                voucher = voucherService.findByCode(voucherCode);
                        }
                        if (voucher != null) order.setDiscount(voucher.getDiscount());
                        else order.setDiscount(0);
                        orderService.checkout(order, cart);
                        request.getSession().setAttribute("order", order.getOrderId());
                        response.sendRedirect(request.getContextPath() + "/purchase");
                }
                catch (Exception ex) {
                        ex.printStackTrace();
                        response.sendRedirect(request.getContextPath() + "/customer/error");
                }
        }
        public static boolean isParsable(String input) {
                if (input.isEmpty() || input == null) { 
                        return false;
                }
                try {
                        Integer.parseInt(input);
                        return true;
                }
                catch (Exception ex) {
                        return false;
                }

        }
}
