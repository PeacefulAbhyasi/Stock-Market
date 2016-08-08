package com.stockmarket.controllers;

import com.stockmarket.models.Person;
import com.stockmarket.services.CompanyStockService;
import com.stockmarket.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class RegistrationController {

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

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerPerson(@ModelAttribute("person") Person person, ModelMap modelMap){
        if(this.personService.checkPersonExist(person.getUserName())){
            modelMap.addAttribute("ERROR","YES");
            modelMap.addAttribute("MESSAGE","USERNAME ALREADY REGISTERED");
            return "RegistrationForm";
        }
        else {
            this.personService.addPerson(person);
            modelMap.addAttribute("ERROR","NO");
            modelMap.addAttribute("MESSAGE","REGISTRATION SUCCESSFUL");
            modelMap.addAttribute("person",person);
            modelMap.addAttribute("subscriptions",companyStockService.listSubscriptions(person.getPersonId()));
            modelMap.addAttribute("nonSubscriptions",companyStockService.listNonSubscriptions(person.getPersonId()));
            return "LoginSuccess";
        }
    }
}
