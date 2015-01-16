package com.ppro.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FrontController {

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("pageName", "default");
        return "template";
    }
}
