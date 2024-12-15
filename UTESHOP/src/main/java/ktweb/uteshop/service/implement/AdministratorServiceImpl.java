package ktweb.uteshop.service.implement;

import ktweb.uteshop.DAO.implement.AdministratorDAOImpl;
import ktweb.uteshop.DAO.interfaces.IAdministratorDAO;
import ktweb.uteshop.entity.Administrator;
import ktweb.uteshop.service.interfaces.IAdministratorService;

import java.util.List;

public class AdministratorServiceImpl implements IAdministratorService {
        IAdministratorDAO administratorDAO = new AdministratorDAOImpl();

        @Override
        public List<Administrator> findAll() {
                return administratorDAO.findAll();
        }

        @Override
        public Administrator findById(int id) {
                return administratorDAO.findById(id);
        }

        @Override
        public void insert(Administrator administrator) {
                administratorDAO.insert(administrator);
        }

        @Override
        public void update(Administrator administrator) {
                administratorDAO.update(administrator);
        }

        @Override
        public void deleteById(int id) {
                administratorDAO.deleteById(id);
        }

        @Override
        public boolean checkLogin(String email, String password) {
                IAdministratorDAO adminDAO = new AdministratorDAOImpl();
                Administrator admin = adminDAO.findByEmail(email);
                if (admin != null && admin.getPassword().equals(password)) {
                        return true;
                }
                return false;
        }
}
