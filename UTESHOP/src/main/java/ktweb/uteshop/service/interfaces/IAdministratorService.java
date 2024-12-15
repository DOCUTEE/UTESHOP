package ktweb.uteshop.service.interfaces;

import ktweb.uteshop.entity.Administrator;

import java.util.List;

public interface IAdministratorService {
        public List<Administrator> findAll();
        public Administrator findById(int id);
        public void insert(Administrator administrator);
        public void update(Administrator administrator);
        public void deleteById(int id);
        public boolean checkLogin(String email, String password);
}
