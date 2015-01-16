package com.ppro.spring.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ppro.spring.service.api.HtmlParserService;
import com.ppro.spring.utils.AppUtils;

@Controller
public class MapController {
    @Autowired
    private HtmlParserService htmlParserService;

    @RequestMapping(value = "/mapa", method = RequestMethod.GET)
    public String position(Model model) {
        return AppUtils.goToPage(model, "map");
    }

    @RequestMapping(value = "/mapa_zpracuj", method = RequestMethod.GET)
    public ModelAndView getResults(@RequestParam("url") String url, @RequestParam("level") int level) {

        ModelAndView mav = new ModelAndView();

        Set<String> map = new HashSet<String>(htmlParserService.getMap(url,level));

        mav.addObject("map", map);
        return AppUtils.goToPageByModelAndView(mav, "map_results");
    }
}
