package ktweb.uteshop.controller.vendor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ktweb.uteshop.entity.Product;
import ktweb.uteshop.entity.Vendor;
import ktweb.uteshop.service.implement.ProductServiceImpl;
import ktweb.uteshop.service.interfaces.IProductService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "VendorHomeController", value = "/VendorHomeController")
public class VendorHomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if (request.getSession().getAttribute("vendor") == null) {
//            response.sendRedirect(request.getContextPath() + "/vendor/login");
//            return;
//        }
        IProductService productService = new ProductServiceImpl();
        Vendor vendor = (Vendor)request.getSession().getAttribute("vendor");
        request.getRequestDispatcher("/vendor/views/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}