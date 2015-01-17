package com.ppro.spring.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ppro.spring.model.User;
import com.ppro.spring.service.api.UserService;
import com.ppro.spring.utils.AppUtils;

@Controller
public class FrontController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        final Set<User> users = userService.getAll();

        //Check if any user not exist then go to registration
        if (users.isEmpty()) {
            return "redirect:registrationForm";
        } else if (AppUtils.getActualLoggedUser() != null){
            return "redirect:profily";
        } else {
            return AppUtils.goToPage(model,"loginPage");
        }
    }

    @RequestMapping(value = "/mobilni_verze", method = RequestMethod.GET)
    public String position(Model model) {
        return AppUtils.goToPage(model, "mobile");
    }
}
