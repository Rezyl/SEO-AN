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
        String message = resolvePosition(key, url, Integer.parseInt(numberOfPage), serverCode);

        mav.addObject("subject", key);
        mav.addObject("message", message);
        mav.addObject("search_engines", Server.getAll());
		return AppUtils.goToPageByModelAndView(mav, "results");
	}

    private String resolvePosition(String key, String url, int numberOfPage, String serverCode) {
        //try load profile
        Profile profile = profileService.loadProfile(url);
        String message;
        if ("ALL".equals(serverCode)) {
            StringBuilder sb = new StringBuilder(String.format("Hledané slovo - %s je ve vyhledávači",key));
            for (Server server : Server.values()) {
                int position = htmlParserService.getPosition(key, url, numberOfPage, server);
                //add result to exist profile
                profileService.addSearchResult(profile,key,position, server);
                sb.append(String.format("%n%s na pozici %s.",server.getName(), position));
            }
            message = sb.toString();
        } else {
            Server server = Server.valueOf(serverCode);
            int position = htmlParserService.getPosition(key, url, numberOfPage, server);
            //add result to exist profile
            profileService.addSearchResult(profile,key,position, server);
            message = String.format("Hledané slovo - %s je ve vyhledávači - %s na pozici %s.",key,server.getName(), position);
        }
        //TODO osetrit kdyz pozice bude 0 tedy nenalezeno
        return message;
    }
}
