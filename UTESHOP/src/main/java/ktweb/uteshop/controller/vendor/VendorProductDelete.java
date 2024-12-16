package ktweb.uteshop.controller.vendor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ktweb.uteshop.service.implement.ProductServiceImpl;
import ktweb.uteshop.service.interfaces.IProductService;

import java.io.IOException;

@WebServlet(name = "VendorProductDelete", value = "/vendor/product/delete")
public class VendorProductDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("id") != null) {
            int productId = Integer.parseInt(request.getParameter("id"));
            IProductService productService = new ProductServiceImpl();
            productService.delete(productId);
            response.sendRedirect(request.getContextPath() + "/vendor/home");
        }
        else
        {
            response.sendRedirect(request.getContextPath()+ "/vendor/home");
            return;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}