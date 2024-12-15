package ktweb.uteshop.controller.customer;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ktweb.uteshop.DAO.interfaces.IMarketingCampaignDAO;
import ktweb.uteshop.entity.MarketingCampaign;
import ktweb.uteshop.entity.Product;
import ktweb.uteshop.service.implement.MarketingCampaignServiceImpl;
import ktweb.uteshop.service.implement.ProductServiceImpl;
import ktweb.uteshop.service.interfaces.IMarketingCampaignService;
import ktweb.uteshop.service.interfaces.IProductService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerController", value = "/home")
public class CustomerController extends HttpServlet {
        IMarketingCampaignService marketingCampaignService = new MarketingCampaignServiceImpl();
        IProductService productService = new ProductServiceImpl();
        @Override
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
                try {
                        List<MarketingCampaign> marketingCampaign = marketingCampaignService.findAll();
                        request.setAttribute("marketingCampaign", marketingCampaign);

                        List<Product> productList = productService.findAll();
                        request.setAttribute("productList", productList);

                        request.getRequestDispatcher("/customer/views/index.jsp").forward(request, response);
                }
                catch (Exception ex) {
                        ex.printStackTrace();
                        response.sendRedirect("/customer/error");
                }
        }
}
