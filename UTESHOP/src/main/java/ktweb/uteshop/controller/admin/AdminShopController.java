package ktweb.uteshop.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ktweb.uteshop.entity.Vendor;
import ktweb.uteshop.service.implement.VendorServiceImpl;
import ktweb.uteshop.service.interfaces.IVendorService;

import java.io.IOException;
import java.util.List;
@WebServlet(name = "AdminShopController", value = "/admin/shop")
public class AdminShopController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("admin") == null) {
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return;
        }
        IVendorService vendorService = new VendorServiceImpl();
        String keyword = request.getParameter("keyword");
        int page = 1;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        List<Vendor> vendorList;
        if (keyword == null) {
            keyword = "";
        }
        vendorList = vendorService.findByKeywordAndPage(keyword, page, 10);
        for (Vendor vendor : vendorList) {
            System.out.println(vendor.getName());
        }
        request.setAttribute("vendorList", vendorList);
        request.getRequestDispatcher("/admin/views/manageShop.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}