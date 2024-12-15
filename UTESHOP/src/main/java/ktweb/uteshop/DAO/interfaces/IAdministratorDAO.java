package ktweb.uteshop.DAO.interfaces;

import ktweb.uteshop.DAO.implement.AdministratorDAOImpl;
import ktweb.uteshop.entity.Administrator;
import org.hibernate.event.spi.SaveOrUpdateEvent;

import java.sql.SQLOutput;
import java.util.List;

public interface IAdministratorDAO {
        List<Administrator> findAll();
        Administrator findById(int id);
        void save(Administrator administrator);
        void update(Administrator administrator);
        void deleteById(int id);

        public static void main(String args[]) {
                IAdministratorDAO administratorDAO = new AdministratorDAOImpl();

                System.out.println("TESTING");

                Administrator administrator = administratorDAO.findById(3);
                System.out.println(administrator.getName());
                administrator.setName("thayThinh");
                administratorDAO.update(administrator);
                administratorDAO.deleteById(4);


        }
}
