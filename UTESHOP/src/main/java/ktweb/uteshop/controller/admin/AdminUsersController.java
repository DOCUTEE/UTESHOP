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
import java.util.List;

@WebServlet(name = "AdminUsersController", value = "/admin/users")
public class AdminUsersController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ICustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null) {
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return;
        }

        String keyword = request.getParameter("keyword");
        int page = 1;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        List<Customer> userList;
        if (keyword == null) {
            keyword = "";
        }
        userList = customerService.findByKeywordAndPage(keyword, page, 10);
        request.setAttribute("userList", userList);
        request.setAttribute("currentPage", page);
        request.setAttribute("keyword", keyword);
        request.getRequestDispatcher("/admin/views/manageUsers.jsp").forward(request, response);
    }
}
