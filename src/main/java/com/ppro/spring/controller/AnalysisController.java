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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
public class AnalysisController {
	@Autowired
	private HtmlParserService htmlParserService;

	@Autowired
	private ProfileService profileService;

	@RequestMapping(value = "/analyza", method = RequestMethod.GET)
	public String position(Model model) {
        model.addAttribute("search_engines", Server.getAll());
		return AppUtils.goToPage(model, "analysis");
	}

	@RequestMapping(value = "/analyza_zpracuj", method = RequestMethod.GET)
    public ModelAndView getResults(@RequestParam("url") String url, @RequestParam("key") String key, @RequestParam("level") int level, @RequestParam("numberOfPage") String numberOfPage, @RequestParam("serverCode") String serverCode, @RequestParam(value = "saveToDB", required = false) boolean saveToDB) {

        ModelAndView mav = new ModelAndView();

        // Pozice
        Map<String, Integer> positions = resolvePosition(key, url, Integer.parseInt(numberOfPage), serverCode);

        // Mapa
        Set<String> map = new HashSet<String>(htmlParserService.getMap(AppUtils.validateURL(url),level));

        // Validita
        String html_validity = htmlParserService.checkHtmlValidity(url);
        String css_validity = htmlParserService.checkCssValidity(url);

        // Index
        String index_google = htmlParserService.checkIndex(url,"google");
        String index_seznam = htmlParserService.checkIndex(url,"seznam");

        mav.addObject("index_google", index_google);
        mav.addObject("index_seznam", index_seznam);
        mav.addObject("html_validity", html_validity);
        mav.addObject("css_validity", css_validity);
        mav.addObject("map", map);
        mav.addObject("subject", key);
        mav.addObject("keyword", key);
        mav.addObject("positions", positions);
        mav.addObject("search_engines", Server.getAll());
		return AppUtils.goToPageByModelAndView(mav, "analysis_results");
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
        return results;
    }
}
