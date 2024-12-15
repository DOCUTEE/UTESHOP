package ktweb.uteshop.controller.customer;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import ktweb.uteshop.entity.Cart;
import ktweb.uteshop.entity.CartItem;
import ktweb.uteshop.entity.Customer;
import ktweb.uteshop.service.implement.CartItemServiceImpl;
import ktweb.uteshop.service.implement.CartServiceImpl;
import ktweb.uteshop.service.implement.ProductServiceImpl;
import ktweb.uteshop.service.interfaces.ICartItemService;
import ktweb.uteshop.service.interfaces.ICartService;
import ktweb.uteshop.service.interfaces.IProductService;

import java.io.IOException;

@WebServlet(name = "AddToCartController", value = "/add-to-cart")
public class AddToCartController extends HttpServlet {
        ICartService cartService = new CartServiceImpl();
        IProductService productService = new ProductServiceImpl();
        ICartItemService cartItemService = new CartItemServiceImpl();
        @Override
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
                try {
                        HttpSession session = request.getSession();
                        if (session.getAttribute("customer") == null) {
                                response.sendRedirect(request.getContextPath() + "/customer/login");
                                return;
                        }
                        Integer productId = Integer.parseInt(request.getParameter("productId"));
                        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
                        Integer customerId = ((Customer) session.getAttribute("customer")).getCustomerId();
                        Cart cart = cartService.findByCustomerId(customerId);
                        CartItem cartItem = new CartItem();
                        cartItem.setProduct(productService.findById(productId));
                        cartItem.setQuantity(quantity);
                        cartItem.setPrice(cartItem.getProduct().getPrice() * quantity);
                        cartItem.setCart(cart);
                        cartItemService.insert(cartItem);
                        response.sendRedirect(request.getHeader("Referer"));
                }
                catch (Exception ex) {
                        ex.printStackTrace();
                        response.sendRedirect(request.getContextPath() + "/customer/error");
                }
        }
}
