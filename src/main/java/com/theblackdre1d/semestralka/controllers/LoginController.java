package com.theblackdre1d.semestralka.controllers;

import com.theblackdre1d.semestralka.forms.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute(name = "loginForm")LoginForm loginForm, Model model) {

        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        if (username.equals("admin") && password.equals("admin")) return "home"; else return "login";
    }
}