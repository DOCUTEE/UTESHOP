package ktweb.uteshop.controller.admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ktweb.uteshop.service.implement.AdministratorServiceImpl;
import ktweb.uteshop.service.interfaces.IAdministratorService;

import java.io.IOException;

@WebServlet(name = "AdminLoginController", value = "/admin/login")
public class AdminLoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/admin/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email= request.getParameter("email");
        String password = request.getParameter("password");
        IAdministratorService administratorService = new AdministratorServiceImpl();
        if (administratorService.checkLogin(email, password)) {
            response.sendRedirect(request.getContextPath() + "/admin/shop");
        } else {
            request.setAttribute("message", "Login failed");
            response.sendRedirect(request.getContextPath() + "/admin/login");
        }

    }
}