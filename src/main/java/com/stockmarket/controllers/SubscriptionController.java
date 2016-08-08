package com.stockmarket.controllers;

import com.stockmarket.services.CompanyStockService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SubscriptionController {

    private CompanyStockService companyStockService;

    @Autowired
    @Qualifier("companyStockService")
    public void setCompanyStockService(CompanyStockService companyStockService) {
        this.companyStockService = companyStockService;
    }

    @RequestMapping(value = "/addSubscription", method = RequestMethod.POST)
    public void addSubscription(@RequestBody String json) throws ParseException {
        JSONParser jsonParser =  new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(json);
        Long personId = (Long) jsonObject.get("personId");
        Long companyId = (Long) jsonObject.get("companyId");
        companyStockService.addSubscription(companyId,personId);
        return ;
    }

}
