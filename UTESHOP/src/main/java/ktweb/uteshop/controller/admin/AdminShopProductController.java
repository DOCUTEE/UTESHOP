package ktweb.uteshop.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ktweb.uteshop.entity.Product;
import ktweb.uteshop.service.implement.ProductServiceImpl;
import ktweb.uteshop.service.interfaces.IProductService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminShopProductController", value = "/admin/shop/product")

public class AdminShopProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        if (keyword == null) {
            keyword = "";
        }
        int page = 1;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        int vendorId = 0;
        if (request.getParameter("vendorId") != null) {
            vendorId = Integer.parseInt(request.getParameter("vendorId"));
        }
        else
        {
            response.sendRedirect(request.getContextPath()+ "/admin/shop");
            return;
        }
        IProductService productService = new ProductServiceImpl();
        List<Product> productList = productService.findByKeywordAndPage(keyword, page, 10, vendorId);
        request.setAttribute("productList", productList);
        for (Product product : productList) {
            System.out.println(product.getName());
        }
        request.getRequestDispatcher("/admin/views/shopProducts.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}