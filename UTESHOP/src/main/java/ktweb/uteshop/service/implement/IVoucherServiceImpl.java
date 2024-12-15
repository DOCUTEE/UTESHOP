package ktweb.uteshop.service.implement;

import ktweb.uteshop.DAO.implement.VoucherDAOImpl;
import ktweb.uteshop.entity.Voucher;
import ktweb.uteshop.service.interfaces.IVoucherService;

import java.util.List;

public class IVoucherServiceImpl implements IVoucherService {
    @Override
    public void insert(Voucher voucher) {
        VoucherDAOImpl voucherDAO = new VoucherDAOImpl();
        voucherDAO.insert(voucher);
    }

    @Override
    public void update(Voucher voucher) {
        VoucherDAOImpl voucherDAO = new VoucherDAOImpl();
        voucherDAO.update(voucher);
    }

    @Override
    public void delete(int voucherId) {
        VoucherDAOImpl voucherDAO = new VoucherDAOImpl();
        voucherDAO.delete(voucherId);
    }

    @Override
    public Voucher findById(int voucherId) {
        VoucherDAOImpl voucherDAO = new VoucherDAOImpl();
        return voucherDAO.findById(voucherId);
    }

    @Override
    public Voucher findByCode(String voucherCode) {
        VoucherDAOImpl voucherDAO = new VoucherDAOImpl();
        return voucherDAO.findByCode(voucherCode);
    }

    @Override
    public List<Voucher> findAll() {
        VoucherDAOImpl voucherDAO = new VoucherDAOImpl();
        return voucherDAO.findAll();
    }

    @Override
    public List<Voucher> findByKeyword(String keyword) {
        VoucherDAOImpl voucherDAO = new VoucherDAOImpl();
        return voucherDAO.findByKeyword(keyword);
    }

    @Override
    public List<Voucher> findByPage(int page, int pageSize) {
        VoucherDAOImpl voucherDAO = new VoucherDAOImpl();
        return voucherDAO.findByPage(page, pageSize);
    }
}
