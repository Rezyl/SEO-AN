package com.ppro.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        return "index";

    }

        @RequestMapping(value = "/getURL", method = RequestMethod.POST)
	public String getResults(Model model, @RequestParam("url") String url) {

        
        Map<String,String> heureka = new HashMap<String, String>();
        ArrayList<String> products = new ArrayList<String>();

        // HEUREKA
        heureka.put("url", url);
        heureka.put("paging_url", "?f=");
        heureka.put("max_page", "4");
        heureka.put("product_link", "h2 a");
        heureka.put("product_name", "h1");

            //http://krmivo-psy.heureka.cz/

        heureka_bot.setConfig(heureka);
        products = heureka_bot.run();
        model.addAttribute("resultList", products);

        return "results";
	}
	
}
