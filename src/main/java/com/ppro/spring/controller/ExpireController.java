package com.ppro.spring.controller;

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

@Controller
public class ExpireController {
	@Autowired
	private HtmlParserService htmlParserService;

	@Autowired
	private ProfileService profileService;

	@RequestMapping(value = "/expirace", method = RequestMethod.GET)
	public String position(Model model) {
		return AppUtils.goToPage(model, "expire");
	}

	@RequestMapping(value = "/expirace_zpracuj", method = RequestMethod.GET)
	public ModelAndView getResults(@RequestParam("domain") String domain) {

        ModelAndView mav = new ModelAndView();

        String expiration = htmlParserService.checkExpiration(domain);

        mav.addObject("expiration", expiration);
		return AppUtils.goToPageByModelAndView(mav, "expire_results");
	}

}
