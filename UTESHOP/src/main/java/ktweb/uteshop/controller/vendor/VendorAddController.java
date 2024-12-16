package ktweb.uteshop.controller.vendor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ktweb.uteshop.entity.Category;
import ktweb.uteshop.entity.Product;
import ktweb.uteshop.entity.ProductImage;
import ktweb.uteshop.entity.Vendor;
import ktweb.uteshop.service.implement.CategoryServiceImpl;
import ktweb.uteshop.service.implement.ProductImageServiceImpl;
import ktweb.uteshop.service.implement.ProductServiceImpl;
import ktweb.uteshop.service.interfaces.ICategoryService;
import ktweb.uteshop.service.interfaces.IProductImageService;
import ktweb.uteshop.service.interfaces.IProductService;

import java.io.IOException;

@WebServlet(name = "VendorAddController", value = "/vendor/product/add")
public class VendorAddController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("vendor") == null) {
            response.sendRedirect(request.getContextPath() + "/vendor/login");
            return;
        }
        request.getRequestDispatcher("/vendor/views/product/add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("vendor") == null) {
            response.sendRedirect(request.getContextPath() + "/vendor/login");
            return;
        }
        String name = request.getParameter("name");
        String descript = request.getParameter("descript");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));
        double weight = Double.parseDouble(request.getParameter("weight"));
        Vendor vendor = (Vendor)request.getSession().getAttribute("vendor");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        String[] productImages = request.getParameterValues("productImages");

        ICategoryService categoryService = new CategoryServiceImpl();
        Category category = categoryService.findById(categoryId);


        // Add product to database
        IProductService productService = new ProductServiceImpl();
        Product product = new Product();
        product.setName(name);
        product.setDescript(descript);
        product.setQuantity(quantity);
        product.setPrice(price);
        product.setWeight(weight);
        product.setVendor(vendor);
        product.setCategory(category);
        IProductImageService productImageService = new ProductImageServiceImpl();
        if (productImages != null) {
            for (String image : productImages) {
                ProductImage productImage = new ProductImage();
                productImage.setProductImage(image);
                productImage.setProduct(product);
                productImageService.insert(productImage);
            }
        }
        productService.insert(product);
        response.sendRedirect(request.getContextPath() + "/vendor/home");
    }
}