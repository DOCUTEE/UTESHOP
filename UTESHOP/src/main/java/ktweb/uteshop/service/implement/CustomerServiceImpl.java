package ktweb.uteshop.service.implement;

import ktweb.uteshop.DAO.implement.CustomerDAOImpl;
import ktweb.uteshop.DAO.interfaces.ICustomerDAO;
import ktweb.uteshop.entity.Customer;
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
        public void insert(Customer customer) {
                customerDAO.insert(customer);
        }

        @Override
        public void update(Customer customer) {
                customerDAO.update(customer);

        }

        @Override
        public void deleteById(int id) {
                customerDAO.deleteById(id);
        }
}