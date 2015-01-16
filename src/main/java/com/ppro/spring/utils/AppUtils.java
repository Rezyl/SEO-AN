package com.ppro.spring.utils;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 1.1.15
 */
public final class AppUtils {

    public static String goToPage(Model model, String pageName) {
        model.addAttribute("pageName", pageName);
        return "template";
    }

    public static String goToPage(ModelMap model, String pageName) {
        model.addAttribute("pageName", pageName);
        return "template";
    }

    public static String validateURL(String url) {
        
        if (!url.startsWith("http://")) {
            url = "http://"+url;
        }

        return url;
    }

    public static ModelAndView goToPageByModelAndView(ModelAndView mav, String pageName) {
        mav.setViewName("template");
        mav.addObject("pageName", pageName);
        return mav;
    }




}
