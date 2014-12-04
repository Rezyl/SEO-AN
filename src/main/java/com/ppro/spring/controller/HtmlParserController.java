package com.ppro.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ppro.spring.service.Bot;

@Controller
public class HtmlParserController {

    @Autowired
    Bot heureka_bot;

    @RequestMapping(value = "/position", method = RequestMethod.GET)
    public String position(Model model) {
        model.addAttribute("pageName", "position");
        return "template";

    }

    @RequestMapping(value = "/getNumberOfPosition", method = RequestMethod.GET)
	public String getResults(Model model, @RequestParam("url") String url, @RequestParam("key") String key,@RequestParam("numberOfPage") String numberOfPage) {
            
        Map<String,String> heureka = new HashMap();
        // HEUREKA

        heureka.put("url", url);
            heureka.put("max_page", numberOfPage);

        heureka.put("paging_url", "?f=");
        heureka.put("product_link", "h2 a");
        heureka.put("product_name", "h1");

        //http://krmivo-psy.heureka.cz/

        heureka_bot.setConfig(heureka);
        List<String> products = heureka_bot.run();
        model.addAttribute("resultList", products);

        model.addAttribute("pageName", "results");
        return "template";
	}

}
