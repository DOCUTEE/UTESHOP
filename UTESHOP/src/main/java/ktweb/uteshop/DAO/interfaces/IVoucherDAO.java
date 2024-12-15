package ktweb.uteshop.DAO.interfaces;

import ktweb.uteshop.entity.Voucher;
import java.util.List;
public interface IVoucherDAO {
    void insert(Voucher voucher);
    void update(Voucher voucher);
    void delete(int voucherId);
    Voucher findById(int voucherId);
    Voucher findByCode(String voucherCode);
    List<Voucher> findAll();
    List<Voucher> findByKeyword(String keyword);
    List<Voucher> findByPage(int page, int pageSize);
}
