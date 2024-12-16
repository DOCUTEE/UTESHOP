package ktweb.uteshop.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ktweb.uteshop.entity.Vendor;
import ktweb.uteshop.service.implement.VendorServiceImpl;
import ktweb.uteshop.service.interfaces.IVendorService;

import java.io.IOException;

@WebServlet(name = "AddVendorController", value = "/admin/add-vendor")
public class AdminAddVendorController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IVendorService vendorService = new VendorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null) {
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return;
        }

        request.getRequestDispatcher("/admin/views/addVendor.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null) {
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return;
        }

        try {
            Vendor vendor = new Vendor();
            vendor.setName(request.getParameter("name"));
            vendor.setEmail(request.getParameter("email"));
            vendor.setPassword(request.getParameter("password"));
            vendor.setPhone(request.getParameter("phone"));
            vendor.setAddress(request.getParameter("address"));
            vendor.setGender(request.getParameter("gender"));
            vendor.setStatus(request.getParameter("status"));
            vendor.setIsDelete(Boolean.parseBoolean(request.getParameter("isDelete")));

            vendorService.insert(vendor);
            response.sendRedirect(request.getContextPath() + "/admin/shop");
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/admin/error");
        }
    }
}
