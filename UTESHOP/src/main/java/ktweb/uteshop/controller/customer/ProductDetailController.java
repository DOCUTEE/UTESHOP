package ktweb.uteshop.controller.customer;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ktweb.uteshop.entity.Product;
import ktweb.uteshop.service.implement.ProductServiceImpl;
import ktweb.uteshop.service.interfaces.IProductService;

import java.io.IOException;


@WebServlet(name = "ProductDetailController", value = "/product-detail")
public class ProductDetailController extends HttpServlet {
        IProductService productService = new ProductServiceImpl();
        @Override
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
                try {
                        if (request.getParameter("productId") == null) {
                                response.sendRedirect(request.getContextPath() + "/customer/error");
                                return;
                        }
                        Integer productId = Integer.parseInt(request.getParameter("productId"));
                        Product product = productService.findById(productId);
                        if (product == null) {
                                response.sendRedirect(request.getContextPath() + "/customer/error");
                                return;
                        }
                        request.setAttribute("product", product);
                        request.getRequestDispatcher("/customer/views/productDetail.jsp").forward(request, response);

                }
                catch (Exception ex) {
                        ex.printStackTrace();
                        response.sendRedirect(request.getContextPath() + "/customer/error");
                }
        }

}
