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
public class IndexController {
	@Autowired
	private HtmlParserService htmlParserService;

	@Autowired
	private ProfileService profileService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String position(Model model) {
		return AppUtils.goToPage(model, "index");
	}

	@RequestMapping(value = "/index_zpracuj", method = RequestMethod.GET)
	public ModelAndView getResults(@RequestParam("url") String url) {

        ModelAndView mav = new ModelAndView();

        String index_google = htmlParserService.checkIndex(url,"google");
        String index_seznam = htmlParserService.checkIndex(url,"seznam");

        mav.addObject("index_google", index_google);
        mav.addObject("index_seznam", index_seznam);
		return AppUtils.goToPageByModelAndView(mav, "index_combined");
	}

}
