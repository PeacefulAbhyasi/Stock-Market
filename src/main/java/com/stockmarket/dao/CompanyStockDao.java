package com.stockmarket.dao;


import com.stockmarket.models.CompanyStock;

import java.util.List;

public interface CompanyStockDao {
    void addCompanyStock(CompanyStock companyStock);
    void changeCompanyStock(CompanyStock companyStock);
    List<CompanyStock> listCompanyStock();
    List<CompanyStock> listSubscriptions(Integer personId);
    List<CompanyStock> listNonSubscriptions(Integer personId);
    void addSubscription(Long companyId, Long personId);
}
