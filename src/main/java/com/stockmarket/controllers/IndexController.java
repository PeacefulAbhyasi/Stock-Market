package com.stockmarket.controllers;

import com.stockmarket.models.CompanyStock;
import com.stockmarket.services.CompanyStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class IndexController {

    private CompanyStockService companyStockService;

    @Autowired
    @Qualifier(value = "companyStockService")
    public void setCompanyStockService(CompanyStockService companyStockService) {
        this.companyStockService = companyStockService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String registerForm(ModelMap modelMap){
        List<CompanyStock> companyStocks  = this.companyStockService.listCompanyStock();
        modelMap.addAttribute("companyStocks",companyStocks);
        return "Index";
    }
}
