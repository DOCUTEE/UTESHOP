package ktweb.uteshop.service.implement;

import ktweb.uteshop.DAO.implement.VendorDAOImpl;
import ktweb.uteshop.entity.Vendor;
import ktweb.uteshop.service.interfaces.IVendorService;

import java.util.List;

public class VendorServiceImpl implements IVendorService {
    @Override
    public void insert(Vendor vendor) {
        VendorDAOImpl vendorDAO = new VendorDAOImpl();
        vendorDAO.insert(vendor);
    }

    @Override
    public void update(Vendor vendor) {
        VendorDAOImpl vendorDAO = new VendorDAOImpl();
        vendorDAO.update(vendor);
    }

    @Override
    public void delete(int vendorId) {
        VendorDAOImpl vendorDAO = new VendorDAOImpl();
        vendorDAO.delete(vendorId);
    }

    @Override
    public Vendor findById(int vendorId) {
        VendorDAOImpl vendorDAO = new VendorDAOImpl();
        return vendorDAO.findById(vendorId);
    }

    @Override
    public Vendor findByName(String vendorName) {
        VendorDAOImpl vendorDAO = new VendorDAOImpl();
        return vendorDAO.findByName(vendorName);
    }

    @Override
    public List<Vendor> findAll() {
        VendorDAOImpl vendorDAO = new VendorDAOImpl();
        return vendorDAO.findAll();
    }

    @Override
    public List<Vendor> findByKeyword(String keyword) {
        VendorDAOImpl vendorDAO = new VendorDAOImpl();
        return vendorDAO.findByKeyword(keyword);
    }

    @Override
    public List<Vendor> findByPage(int page, int pageSize) {
        VendorDAOImpl vendorDAO = new VendorDAOImpl();
        return vendorDAO.findByPage(page, pageSize);
    }
    @Override
    public List<Vendor> findByKeywordAndPage(String keyword, int page, int pageSize) {
        VendorDAOImpl vendorDAO = new VendorDAOImpl();
        return vendorDAO.findByKeywordAndPage(keyword, page, pageSize);
    }
    @Override
    public Vendor findByEmail(String email) {
        VendorDAOImpl vendorDAO = new VendorDAOImpl();
        return vendorDAO.findByEmail(email);
    }
    @Override
    public boolean checkLogin(String email, String password) {
        VendorDAOImpl vendorDAO = new VendorDAOImpl();
        Vendor vendor = vendorDAO.findByEmail(email);
        if (vendor != null && vendor.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
