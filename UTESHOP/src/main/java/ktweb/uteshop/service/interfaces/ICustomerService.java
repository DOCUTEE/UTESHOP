package ktweb.uteshop.service.interfaces;

import ktweb.uteshop.entity.Customer;

import java.util.List;

public interface ICustomerService {
        public List<Customer> findAllByPage(int page, int limit);
        public Customer findById(int id);
        public void insert(Customer customer);
        public void update(Customer customer);
        public void deleteById(int id);
}
