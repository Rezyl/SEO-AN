package com.ppro.spring.controller;

import java.util.HashMap;
import java.util.Map;

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
	public ModelAndView getResults(@RequestParam("url") String url, @RequestParam("key") String key, @RequestParam("numberOfPage") String numberOfPage, @RequestParam("serverCode") String serverCode, @RequestParam(value = "saveToDB", required = false) boolean saveToDB) {

        ModelAndView mav = new ModelAndView();

        Map<String, Integer> positions = resolvePosition(key, url, Integer.parseInt(numberOfPage), serverCode);

        //if user wants to save information to profile
        if (saveToDB) {
            saveResultPositionsToProfile(positions,key,url);
        }

        mav.addObject("subject", key);
        mav.addObject("keyword", key);
        mav.addObject("positions", positions);
        mav.addObject("search_engines", Server.getAll());
		return AppUtils.goToPageByModelAndView(mav, "position_results");
	}

    protected Map<String, Integer> resolvePosition(String key, String url, int numberOfPage, String serverCode) {
        int position;

        Map<String, Integer> results = new HashMap<String, Integer>();
        if ("ALL".equals(serverCode)) {
            for (Server server : Server.values()) {
                position = htmlParserService.getPosition(key, url, numberOfPage, server);
                results.put(server.getName(),position);
            }
        } else {
            Server server = Server.valueOf(serverCode);
            position = htmlParserService.getPosition(key, url, numberOfPage, server);
            results.put(server.getName(),position);
        }
        //TODO osetrit kdyz pozice bude 0 tedy nenalezeno
        return results;
    }

    protected void saveResultPositionsToProfile(Map<String, Integer> results, String key, String url) {
        //try load profile
        Profile profile = profileService.loadProfile(url);
        for (Map.Entry<String, Integer> mapEntry : results.entrySet()) {
            Server server = Server.getServerByName(mapEntry.getKey());
            //add result to exist profile
            profileService.addSearchResult(profile,key,mapEntry.getValue(), server);
        }
    }
}
