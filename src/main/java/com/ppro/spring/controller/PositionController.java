package com.ppro.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ppro.spring.model.Profile;
import com.ppro.spring.service.api.HtmlParserService;
import com.ppro.spring.service.api.ProfileService;
import com.ppro.spring.utils.AppUtils;

@Controller
public class PositionController {
	@Autowired
	private HtmlParserService htmlParserService;

	@Autowired
	private ProfileService profileService;

	@RequestMapping(value = "/pozice", method = RequestMethod.GET)
	public String position(Model model) {
		return AppUtils.goToPage(model, "position");
	}

	@RequestMapping(value = "/pozice_zpracuj", method = RequestMethod.GET)
	public ModelAndView getResults(@RequestParam("url") String url, @RequestParam("key") String key, @RequestParam("numberOfPage") String numberOfPage) {

        ModelAndView mav = new ModelAndView();
        //find position
		int position = htmlParserService.getPosition(key, url, Integer.parseInt(numberOfPage));

        //try load profile
        Profile profile = profileService.loadProfile(url);
        //add result to exist profile
        profileService.addSearchResult(profile,key,position);

        mav.addObject("subject", key);
        mav.addObject("position", position);
		return AppUtils.goToPageByModelAndView(mav, "results");
	}
}
