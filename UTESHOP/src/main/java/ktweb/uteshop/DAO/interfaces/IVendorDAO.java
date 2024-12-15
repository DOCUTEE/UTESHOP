package ktweb.uteshop.DAO.interfaces;

import ktweb.uteshop.entity.Vendor;
import java.util.List;

public interface IVendorDAO {
    void insert(Vendor vendor);
    void update(Vendor vendor);
    void delete(int vendorId);
    Vendor findById(int vendorId);
    Vendor findByName(String vendorName);
    List<Vendor> findAll();
    List<Vendor> findByKeyword(String keyword);
    List<Vendor> findByPage(int page, int pageSize);
}
