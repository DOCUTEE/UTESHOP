package ktweb.uteshop.controller.vendor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ktweb.uteshop.service.implement.CategoryServiceImpl;
import ktweb.uteshop.service.implement.VendorServiceImpl;
import ktweb.uteshop.service.interfaces.ICategoryService;
import ktweb.uteshop.service.interfaces.IVendorService;

import java.io.IOException;

@WebServlet(name = "VendorLoginController", value = "/vendor/login")
public class VendorLoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("vendor") != null) {
            response.sendRedirect(request.getContextPath() + "/vendor/home");
            return;
        }
        request.getRequestDispatcher("/vendor/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        IVendorService vendorService = new VendorServiceImpl();
        if (vendorService.checkLogin(email, password)) {
            ICategoryService categoryService = new CategoryServiceImpl();
            request.getSession().setAttribute("categories", categoryService.findAll());
            request.getSession().setAttribute("vendor", vendorService.findByEmail(email));
            response.sendRedirect(request.getContextPath() + "/vendor/home");
        } else {
            request.setAttribute("message", "Login failed");
            response.sendRedirect(request.getContextPath() + "/vendor/login");
        }
    }
}