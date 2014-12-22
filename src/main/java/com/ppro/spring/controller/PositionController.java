package com.ppro.spring.controller;

import com.ppro.spring.service.HtmlParserService;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PositionController
{
    @Autowired
    private HtmlParserService HtmlParser;

    @RequestMapping(value = "/pozice", method = RequestMethod.GET)
    public String position(Model model)
    {
        model.addAttribute("pageName", "position");
        return "template";
    }

    @RequestMapping(value = "/pozice_zpracuj", method = RequestMethod.GET)
	public String getResults(Model model, @RequestParam("url") String url,@RequestParam("key") String key,@RequestParam("numberOfPage") String numberOfPage)
    {
        int number_of_pages = Integer.parseInt(numberOfPage);

        // Seznam.cz
        Elements elements = HtmlParser.getElements("http://search.seznam.cz/?q="+key+"&count=10&from=", 0, 10, number_of_pages, ".info a");
        List<String> links = HtmlParser.getAttributes(elements, "href");

        int position = 0;

        for (int i = 0; i < links.size(); i++)
        {
            if (links.get(i).equals(url))
            {
                position = i + 1;
            }
        }

        model.addAttribute("resultList", links);
        model.addAttribute("position", position);
        model.addAttribute("pageName", "results");
        return "template";
	}
}
