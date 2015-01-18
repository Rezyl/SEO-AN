package com.ppro.spring.utils;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        model.addAttribute("userName", getActualLoggedUser());
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
        mav.addObject("userName", getActualLoggedUser());
        return mav;
    }

	public static String getActualLoggedUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth instanceof AnonymousAuthenticationToken) {
            return null;
        } else {
            return auth.getName();
        }
	}
}
