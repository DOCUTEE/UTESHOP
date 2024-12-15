package ktweb.uteshop.controller.customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ktweb.uteshop.service.implement.AdministratorServiceImpl;
import ktweb.uteshop.service.implement.CustomerServiceImpl;
import ktweb.uteshop.service.interfaces.IAdministratorService;
import ktweb.uteshop.service.interfaces.ICustomerService;

import java.io.IOException;

@WebServlet(name = "LoginController", value = "/customer/login")
public class LoginController extends HttpServlet {
        ICustomerService customerService = new CustomerServiceImpl();
        @Override
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
                HttpSession session = request.getSession(false);
                try {
                        if (session != null && session.getAttribute("customer") != null) {
                                response.sendRedirect(request.getContextPath() + "/customer/home");
                        } else {
                                request.getRequestDispatcher("/customer/views/login.jsp").forward(request, response);
                        }
                }
                catch (Exception ex) {
                        ex.printStackTrace();
                        response.sendRedirect("/error");
                }
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                String email = request.getParameter("email");
                String password = request.getParameter("password");

                if (email == null || password == null) {
                        request.setAttribute("error", "Email or password is incorrect.");
                        request.getRequestDispatcher("/customer/views/login.jsp").forward(request, response);
                        return;
                }

                if (customerService.login(email, password)) {
                        HttpSession session = request.getSession();
                        session.setAttribute("customer", customerService.findByEmail(email));
                        response.sendRedirect(request.getContextPath() + "/customer/home");
                } else {
                        request.setAttribute("error", "Email or password is incorrect.");
                        request.getRequestDispatcher("/customer/views/login.jsp").forward(request, response);
                }
        }
}
