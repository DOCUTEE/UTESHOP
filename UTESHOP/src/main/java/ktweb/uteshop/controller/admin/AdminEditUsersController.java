package ktweb.uteshop.controller.admin;

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

@WebServlet(name = "EditUserController", value = "/admin/edit-user")
public class AdminEditUsersController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ICustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null) {
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return;
        }

        int customerId = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(customerId);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("/admin/views/editUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null) {
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return;
        }

        try {
            int customerId = Integer.parseInt(request.getParameter("id"));
            Customer customer = customerService.findById(customerId);
            customer.setName(request.getParameter("name"));
            customer.setEmail(request.getParameter("email"));
            customer.setPhone(request.getParameter("phone"));
            customer.setAddress(request.getParameter("address"));
            customer.setGender(request.getParameter("gender"));
            customer.setStatus(request.getParameter("status"));
            customer.setIsDelete(Boolean.parseBoolean(request.getParameter("isDelete")));

            customerService.update(customer);
            response.sendRedirect(request.getContextPath() + "/admin/users");
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/admin/error");
        }
    }
}
