package ktweb.uteshop.controller.vendor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ktweb.uteshop.entity.Category;
import ktweb.uteshop.entity.Product;
import ktweb.uteshop.entity.ProductImage;
import ktweb.uteshop.service.implement.CategoryServiceImpl;
import ktweb.uteshop.service.implement.ProductServiceImpl;
import ktweb.uteshop.service.interfaces.ICategoryService;
import ktweb.uteshop.service.interfaces.IProductService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "VendorProductEditController", value = "/vendor/product/edit")
public class VendorProductEditController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("vendor") == null) {
            response.sendRedirect(request.getContextPath() + "/vendor/login");
            return;
        }
        int productId = Integer.parseInt(request.getParameter("id"));
        IProductService productService = new ProductServiceImpl();
        request.setAttribute("product", productService.findById(productId));
        request.getRequestDispatcher("/vendor/views/product/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("vendor") == null) {
            response.sendRedirect(request.getContextPath() + "/vendor/login");
            return;
        }

        try {
            // Lấy thông tin từ form
            int productId = Integer.parseInt(request.getParameter("productId"));
            String name = request.getParameter("name");
            String descript = request.getParameter("descript");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            double price = Double.parseDouble(request.getParameter("price"));
            double weight = Double.parseDouble(request.getParameter("weight"));
            int categoryId = Integer.parseInt(request.getParameter("categoryId")); // Lấy categoryId từ form

            // Lấy danh sách productImages từ form
            String[] productImages = request.getParameterValues("productImages");

            // Tạo đối tượng ProductService và tìm sản phẩm theo ID
            IProductService productService = new ProductServiceImpl();
            Product product = productService.findById(productId);

            // Nếu sản phẩm không tồn tại, chuyển hướng về trang home
            if (product == null) {
                response.sendRedirect(request.getContextPath() + "/vendor/home");
                return;
            }

            // Cập nhật các trường thông tin
            product.setName(name);
            product.setDescript(descript);
            product.setQuantity(quantity);
            product.setPrice(price);
            product.setWeight(weight);

            // Lấy category từ database
            ICategoryService categoryService = new CategoryServiceImpl();
            Category category = categoryService.findById(categoryId);
            product.setCategory(category);

            // Cập nhật danh sách ProductImage
            List<ProductImage> updatedProductImages = new ArrayList<>();
            if (productImages != null) {
                for (String imageUrl : productImages) {
                    ProductImage productImage = new ProductImage();
                    productImage.setProductImage(imageUrl);
                    productImage.setProduct(product);
                    updatedProductImages.add(productImage);
                }
            }

            // Cập nhật lại danh sách hình ảnh
            product.setProductImages(updatedProductImages);

            // Lưu sản phẩm đã cập nhật vào cơ sở dữ liệu
            productService.update(product);

            // Chuyển hướng về trang home với thông báo thành công
            request.getSession().setAttribute("message", "Product updated successfully!");
            response.sendRedirect(request.getContextPath() + "/vendor/home");

        } catch (Exception e) {
            // Xử lý lỗi nếu có và chuyển hướng về form với thông báo lỗi
            request.setAttribute("message", "Error updating product: " + e.getMessage());
            request.getRequestDispatcher("/vendor/views/editProduct.jsp").forward(request, response);
        }
    }

}