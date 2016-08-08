package com.stockmarket.services;

import com.stockmarket.dao.CompanyStockDao;
import com.stockmarket.models.CompanyStock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyStockServiceImpl implements CompanyStockService {

    private CompanyStockDao companyStockDao;

    public void setCompanyStockDao(CompanyStockDao companyStockDao) {
        this.companyStockDao = companyStockDao;
    }

    @Transactional
    public void addCompanyStock(CompanyStock companyStock) {
        this.companyStockDao.addCompanyStock(companyStock);
    }
    @Transactional
    public void changeCompanyStock(CompanyStock companyStock) {
        this.companyStockDao.changeCompanyStock(companyStock);
    }
    @Transactional
    public List<CompanyStock> listCompanyStock() {
        return this.companyStockDao.listCompanyStock();
    }
    @Transactional
    public List<CompanyStock> listSubscriptions(Integer personId) {
        return this.companyStockDao.listSubscriptions(personId);
    }
    @Transactional
    public List<CompanyStock> listNonSubscriptions(Integer personId) {
        return this.companyStockDao.listNonSubscriptions(personId);
    }
    @Transactional
    public void addSubscription(Long companyId, Long personId) {
        this.companyStockDao.addSubscription(companyId,personId);
    }
}
