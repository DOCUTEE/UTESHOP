package ktweb.uteshop.controller.customer;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import ktweb.uteshop.service.implement.CartItemServiceImpl;
import ktweb.uteshop.service.interfaces.ICartItemService;

import java.io.IOException;

@WebServlet(name = "RemoveCartItemController", value = "/remove-from-cart")
public class RemoveCartItemController extends HttpServlet {
        ICartItemService cartItemService = new CartItemServiceImpl();
        @Override
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
                try {
                        HttpSession session = request.getSession();
                        if (session.getAttribute("customer") == null) {
                                response.sendRedirect(request.getContextPath() + "/customer/login");
                                return;
                        }
                        Integer cartItemId = null;
                        if (request.getParameter("cartItemId") != null) {
                                cartItemId = Integer.parseInt(request.getParameter("cartItemId"));
                        }
                        cartItemService.deleteById(cartItemId);
                        response.sendRedirect(request.getHeader("Referer"));
                }
                catch (Exception ex) {
                        response.sendRedirect(request.getContextPath() + "/customer/error");
                        ex.printStackTrace();
                }
        }
}
