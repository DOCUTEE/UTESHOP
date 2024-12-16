package ktweb.uteshop.service.interfaces;

import ktweb.uteshop.entity.Vendor;

import java.util.List;

public interface IVendorService {
    void insert(Vendor vendor);
    void update(Vendor vendor);
    void delete(int vendorId);
    Vendor findById(int vendorId);
    Vendor findByName(String vendorName);
    List<Vendor> findAll();
    List<Vendor> findByKeyword(String keyword);
    List<Vendor> findByPage(int page, int pageSize);
    List<Vendor> findByKeywordAndPage(String keyword, int page, int pageSize);
    Vendor findByEmail(String email);
    boolean checkLogin(String email, String password);
}
