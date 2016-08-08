package com.stockmarket.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminPanelController {
    @RequestMapping(value = "/adminPanel", method = RequestMethod.GET)
    public String showAdminPanel(){
        return "AdminPanel";
    }
}
