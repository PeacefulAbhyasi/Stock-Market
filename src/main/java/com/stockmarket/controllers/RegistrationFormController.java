package com.stockmarket.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationFormController {
    @RequestMapping(value = "/registrationForm", method = RequestMethod.GET)
    public String registrationForm(){
        return "RegistrationForm";
    }

}
