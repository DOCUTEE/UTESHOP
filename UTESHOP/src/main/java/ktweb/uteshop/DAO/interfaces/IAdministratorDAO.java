package ktweb.uteshop.DAO.interfaces;

import ktweb.uteshop.DAO.implement.AdministratorDAOImpl;
import ktweb.uteshop.entity.Administrator;

import java.util.List;

public interface IAdministratorDAO {
        List<Administrator> findAll();
        Administrator findById(int id);
        void insert(Administrator administrator);
        void update(Administrator administrator);
        void deleteById(int id);

        public static void main(String args[]) {

        }

        Administrator getAdministrator(String email);
}
