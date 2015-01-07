package com.ppro.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ppro.spring.model.Profile;
import com.ppro.spring.model.Server;
import com.ppro.spring.service.api.HtmlParserService;
import com.ppro.spring.service.api.ProfileService;
import com.ppro.spring.utils.AppUtils;

import java.util.HashMap;
import java.util.Map;

@Controller
public class PositionController {
	@Autowired
	private HtmlParserService htmlParserService;

	@Autowired
	private ProfileService profileService;

	@RequestMapping(value = "/pozice", method = RequestMethod.GET)
	public String position(Model model) {
        model.addAttribute("search_engines", Server.getAll());
		return AppUtils.goToPage(model, "position");
	}

	@RequestMapping(value = "/pozice_zpracuj", method = RequestMethod.GET)
	public ModelAndView getResults(@RequestParam("url") String url, @RequestParam("key") String key, @RequestParam("numberOfPage") String numberOfPage, @RequestParam("serverCode") String serverCode) {

        ModelAndView mav = new ModelAndView();
        //find positions
        Map positions = resolvePosition(key, url, Integer.parseInt(numberOfPage), serverCode);

        String search_engine = Server.valueOf(serverCode).getName();

        mav.addObject("subject", key);
        mav.addObject("keyword", key);
        mav.addObject("search_engine", search_engine);
        mav.addObject("positions", positions);
        mav.addObject("search_engines", Server.getAll());
		return AppUtils.goToPageByModelAndView(mav, "position_results");
	}

    private Map resolvePosition(String key, String url, int numberOfPage, String serverCode) {
        //try load profile
        Profile profile = profileService.loadProfile(url);
        int position = 0;

        Map<String, Integer> results = new HashMap<String, Integer>();
        //TODO opravit zjištění pozice pro všechny vyhledávače
        if ("ALL".equals(serverCode)) {
            //StringBuilder sb = new StringBuilder(String.format("Hledané slovo - %s je ve vyhledávači",key));
            for (Server server : Server.values()) {
                position = htmlParserService.getPosition(key, url, numberOfPage, server);
                //add result to exist profile
                profileService.addSearchResult(profile,key,position, server);
                results.put(server.getName(),position);
            }
        } else {
            Server server = Server.valueOf(serverCode);
            position = htmlParserService.getPosition(key, url, numberOfPage, server);
            results.put(server.getName(),position);
            //add result to exist profile
            profileService.addSearchResult(profile,key,position, server);
        }
        //TODO osetrit kdyz pozice bude 0 tedy nenalezeno
        return results;
    }
}
