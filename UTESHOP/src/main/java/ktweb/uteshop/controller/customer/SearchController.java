package ktweb.uteshop.controller.customer;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ktweb.uteshop.entity.Product;
import ktweb.uteshop.service.implement.ProductServiceImpl;
import ktweb.uteshop.service.interfaces.IProductService;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

@WebServlet(name = "SearchController", value = "/search")
public class SearchController extends HttpServlet {
        IProductService productService = new ProductServiceImpl();
        private static final Integer PRODUCT_BY_PAGE = 10;
        @Override
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
                try {
                        if (request.getParameter("keyword") == null) {
                                response.sendRedirect(request.getContextPath() + "/home");
                                return;
                        }
                        String keyword = request.getParameter("keyword");
                        if (keyword == null) {
                                response.sendRedirect(request.getContextPath() + "/home");
                                return;
                        }
                        Integer page = 1;
                        if (request.getParameter("page") != null) {
                                page = Integer.parseInt(request.getParameter("page"));
                        }

                        List<Product> productList = productService.findByKeywordAndPage(keyword, page, PRODUCT_BY_PAGE);
                        request.setAttribute("page", page);
                        request.setAttribute("keyword", keyword);
                        request.setAttribute("productList", productList);
                        request.getRequestDispatcher("/customer/views/search.jsp").forward(request, response);
                }
                catch (Exception ex) {
                        ex.printStackTrace();
                        response.sendRedirect(request.getContextPath() + "/customer/error");
                }
        }
}
