package com.ppro.spring.controller;

import com.ppro.spring.service.Bot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PositionController {

    @Autowired
    Bot seznam_cz_bot;

    @RequestMapping(value = "/pozice", method = RequestMethod.GET)
    public String position(Model model) {
        model.addAttribute("pageName", "position");
        return "template";

    }

    @RequestMapping(value = "/pozice_zpracuj", method = RequestMethod.GET)
	public String getResults(Model model, @RequestParam("url") String url,@RequestParam("key") String key,@RequestParam("numberOfPage") String numberOfPage) {
            
        Map<String,String> seznam_cz = new HashMap();

        seznam_cz.put("url", "http://search.seznam.cz/?q="+key);
        seznam_cz.put("max_page", numberOfPage);

        seznam_cz.put("paging_url", "&count=10&from=");
        seznam_cz.put("product_link", "h3 a");
        seznam_cz.put("product_name", ".info a");

        seznam_cz_bot.setConfig(seznam_cz);
        List<String> positions = seznam_cz_bot.run();
        model.addAttribute("resultList", positions);

        model.addAttribute("pageName", "results");
        return "template";
	}

}
