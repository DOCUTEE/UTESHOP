package ktweb.uteshop.controller.customer;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import ktweb.uteshop.entity.Customer;
import ktweb.uteshop.service.implement.CartServiceImpl;
import ktweb.uteshop.service.interfaces.ICartService;
import ktweb.uteshop.entity.Cart;

import java.io.IOException;

@WebServlet(name = "CartController", value = "/cart")
public class CartController extends HttpServlet {
        ICartService cartService = new CartServiceImpl();
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
                        request.getRequestDispatcher("/customer/views/cart.jsp").forward(request, response);
                }
                catch (Exception ex) {
                        ex.printStackTrace();
                        response.sendRedirect(request.getContextPath() + "/customer/error");
                }
        }
}
