package ktweb.uteshop.controller.customer;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LogoutController", value = "/customer/logout")
public class LogoutController extends HttpServlet {
        @Override
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
                try {
                        HttpSession session = request.getSession();
                        session.removeAttribute("customer");
                        response.sendRedirect(request.getContextPath() + "/home");
                }
                catch (Exception ex) {
                        ex.printStackTrace();
                        response.sendRedirect("/customer/error");
                }
        }
}
