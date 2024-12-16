package ktweb.uteshop.controller.customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ktweb.uteshop.entity.Customer;
import ktweb.uteshop.service.implement.CustomerServiceImpl;
import ktweb.uteshop.service.interfaces.ICustomerService;

import java.io.IOException;

@WebServlet(name = "EditProfileController", value = "/customer/edit-profile")
public class EditProfileController extends HttpServlet {
    ICustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session == null || session.getAttribute("customer") == null) {
            response.sendRedirect(request.getContextPath() + "/customer/login");
            return;
        }

        request.getRequestDispatcher("/customer/views/editProfile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session == null || session.getAttribute("customer") == null) {
            response.sendRedirect(request.getContextPath() + "/customer/login");
            return;
        }

        try {
            Customer customer = (Customer) session.getAttribute("customer");
            customer.setName(request.getParameter("name"));
            customer.setEmail(request.getParameter("email"));
            customer.setPhone(request.getParameter("phone"));
            customer.setAddress(request.getParameter("address"));
            customer.setGender(request.getParameter("gender"));
            customer.setStatus(request.getParameter("status"));

            customerService.update(customer);
            session.setAttribute("customer", customer);

            response.sendRedirect(request.getContextPath() + "/customer/profile");
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/customer/error");
        }
    }
}
