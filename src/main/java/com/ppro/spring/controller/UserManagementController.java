package com.ppro.spring.controller;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ppro.spring.model.Role;
import com.ppro.spring.model.User;
import com.ppro.spring.service.api.UserService;
import com.ppro.spring.utils.AppUtils;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 1.1.15
 */
@Controller
public class UserManagementController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        return AppUtils.goToPageByModelAndView(model, "loginPage");
    }

    @RequestMapping(value = "/registrationForm", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("newUser", new User());
        return AppUtils.goToPage(model, "registration");
    }

    @RequestMapping(value = "/submitRegistration", method = RequestMethod.POST)
    public String registration(Model model, @ModelAttribute(value = "newUser") User user) {

        user.setRole(Role.ROLE_USER);
        //get hashed password
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        try {
            userService.save(user);
        } catch (ConstraintViolationException e) {
            model.addAttribute("err", "Toto uživatelské jméno je již použito");
            return AppUtils.goToPage(model, "registration");
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/ucet", method = RequestMethod.GET)
    public String account(Model model) {

        return AppUtils.goToPage(model, "account");
    }
}
