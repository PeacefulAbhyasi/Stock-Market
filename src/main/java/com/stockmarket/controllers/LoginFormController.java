package com.stockmarket.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginFormController {
    @RequestMapping(value = "/loginForm", method = RequestMethod.GET)
    public String loginForm(){
        return "LoginForm";
    }

}
