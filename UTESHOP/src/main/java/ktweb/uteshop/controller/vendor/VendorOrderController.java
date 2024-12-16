package ktweb.uteshop.controller.vendor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ktweb.uteshop.entity.Order;
import ktweb.uteshop.entity.OrderItem;
import ktweb.uteshop.entity.Vendor;
import ktweb.uteshop.service.implement.OrderItemServiceImpl;
import ktweb.uteshop.service.implement.OrderServiceImpl;
import ktweb.uteshop.service.interfaces.IOrderItemService;
import ktweb.uteshop.service.interfaces.IOrderService;

import java.io.IOException;
import java.util.List;
@WebServlet(name = "VendorOrderController", value = "/vendor/order")
public class VendorOrderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("vendor") == null) {
            response.sendRedirect(request.getContextPath() + "/vendor/login");
            return;
        }
        Vendor vendor = (Vendor) request.getSession().getAttribute("vendor");
        //get all orders of vendor
        IOrderItemService orderItemService = new OrderItemServiceImpl();
        int page = 1;
        int pageSize = 10;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        List<OrderItem> orderItems = orderItemService.findOrderItemsOfVendor(vendor.getVendorId(),page,pageSize);
        request.setAttribute("orderItems", orderItems);
        request.getRequestDispatcher("/vendor/views/orderItems.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}