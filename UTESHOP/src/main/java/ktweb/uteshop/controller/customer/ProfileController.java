package ktweb.uteshop.controller.customer;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "ProfileController", value = "/customer/profile")
public class ProfileController extends HttpServlet {
        @Override
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
                try {
                        HttpSession session = request.getSession();
                        if (session == null || session.getAttribute("customer") == null) {
                                response.sendRedirect(request.getContextPath() + "/customer/login");
                                return;
                        }
                        request.getRequestDispatcher("/customer/views/profile.jsp").forward(request, response);
                }
                catch (Exception ex) {
                        ex.printStackTrace();
                        response.sendRedirect(request.getContextPath()+"/customer/error");
                }
        }
}
