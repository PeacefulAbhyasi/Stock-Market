package com.stockmarket.controllers;

import com.stockmarket.models.CompanyStock;
import com.stockmarket.services.CompanyStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PanelController {
    private CompanyStockService companyStockService;

    @Autowired
    @Qualifier(value = "companyStockService")
    public void setCompanyStockService(CompanyStockService companyStockService) {
        this.companyStockService = companyStockService;
    }


    @RequestMapping(value = "/addCompanyStock", method = RequestMethod.POST)
    public String addCompanyStock(@ModelAttribute("companyStock") CompanyStock companyStock){
        companyStockService.addCompanyStock(companyStock);
        return "AdminPanel";
    }

    @RequestMapping(value = "/changeCompanyStock", method = RequestMethod.POST)
    public String changeCompanyStock(@ModelAttribute("companyStock") CompanyStock companyStock){
        companyStockService.changeCompanyStock(companyStock);
        return "AdminPanel";
    }
}
