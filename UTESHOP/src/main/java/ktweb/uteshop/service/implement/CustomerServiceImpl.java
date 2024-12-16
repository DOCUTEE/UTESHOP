package ktweb.uteshop.service.implement;

import ktweb.uteshop.DAO.implement.CustomerDAOImpl;
import ktweb.uteshop.DAO.interfaces.ICustomerDAO;
import ktweb.uteshop.entity.Cart;
import ktweb.uteshop.entity.Customer;
import ktweb.uteshop.service.interfaces.ICartService;
import ktweb.uteshop.service.interfaces.ICustomerService;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
        ICustomerDAO customerDAO = new CustomerDAOImpl();
        @Override
        public List<Customer> findAllByPage(int page, int limit) {
                return customerDAO.findAllByPage(page, limit);
        }

        @Override
        public Customer findById(int id) {
                return customerDAO.findById(id);
        }

        @Override
        public boolean insert(Customer customer) {
                if (customerDAO.insert(customer)) {
                        ICartService cartService = new CartServiceImpl();
                        Cart cart = new Cart();
                        cart.setCustomer(customer);
                        cartService.insert(cart);
                        return true;
                }
                return false;
        }

        @Override
        public void update(Customer customer) {
                customerDAO.update(customer);

        }

        @Override
        public void deleteById(int id) {
                customerDAO.deleteById(id);
        }

        @Override
        public boolean login(String email, String password) {
                Customer customer = customerDAO.findByEmail(email);
                if (customer != null) {
                        return customer.getPassword().equals(password);
                }
                return false;
        }

        @Override
        public List<Customer> findByKeywordAndPage(String keyword, int page, int limit) {
                return customerDAO.findByKeywordAndPage(keyword, page, limit);
        }

        @Override
        public Customer findByEmail(String email) {
                return customerDAO.findByEmail(email);
        }


}
