package com.stockmarket.controllers;

import com.stockmarket.models.Person;
import com.stockmarket.services.CompanyStockService;
import com.stockmarket.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private PersonService personService;
    private CompanyStockService companyStockService;
    @Autowired
    @Qualifier(value = "personService")
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @Autowired
    @Qualifier(value = "companyStockService")
    public void setCompanyStockService(CompanyStockService companyStockService) {
        this.companyStockService = companyStockService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPerson(@RequestParam("userName") String userName, @RequestParam("password") String password, ModelMap modelMap){
        if(personService.checkPersonExist(userName)){
            if(personService.checkPassword(userName,password)){
                Person person  = this.personService.findPerson(userName);
                modelMap.addAttribute("person",person);
                modelMap.addAttribute("subscriptions",companyStockService.listSubscriptions(person.getPersonId()));
                modelMap.addAttribute("nonSubscriptions",companyStockService.listNonSubscriptions(person.getPersonId()));
            }
            else{
                modelMap.addAttribute("ERROR","YES");
                modelMap.addAttribute("MESSAGE","WRONG PASSWORD");
                return "LoginForm";
            }
        }
        else{
            modelMap.addAttribute("ERROR","YES");
            modelMap.addAttribute("MESSAGE","USERNAME DOES NOT EXIST");
            return "LoginForm";
        }
        return "LoginSuccess";
    }
}
