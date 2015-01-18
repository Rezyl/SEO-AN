package com.ppro.spring.controller;

import com.ppro.spring.model.Profile;
import com.ppro.spring.model.Server;
import com.ppro.spring.service.api.HtmlParserService;
import com.ppro.spring.service.api.ProfileService;
import com.ppro.spring.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class ValidityController {
	@Autowired
	private HtmlParserService htmlParserService;

	@Autowired
	private ProfileService profileService;

	@RequestMapping(value = "/validita", method = RequestMethod.GET)
	public String position(Model model) {
		return AppUtils.goToPage(model, "validity");
	}

	@RequestMapping(value = "/validita_zpracuj", method = RequestMethod.GET)
	public ModelAndView getResults(@RequestParam("url") String url) {

        ModelAndView mav = new ModelAndView();

        String html_validity = htmlParserService.checkHtmlValidity(url);
        String css_validity = htmlParserService.checkCssValidity(url);

        mav.addObject("html_validity", html_validity);
        mav.addObject("css_validity", css_validity);
		return AppUtils.goToPageByModelAndView(mav, "validity_combined");
	}
}
