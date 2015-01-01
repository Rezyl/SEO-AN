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
        int seznam_position = getSeznamPosition(url, key, number_of_pages);

        // Google.com
        int google_position = getGooglePosition(url, key, number_of_pages);

        // Centrum.cz
        int centrum_position = getCentrumPosition(url, key, number_of_pages);

        Elements elements = HtmlParser.getElements("http://www.google.cz/search?q="+key+"&start=", 0, 10, number_of_pages, "a");
        List<String> links = HtmlParser.getAttributes(elements, "href");

        model.addAttribute("resultList", links);
        model.addAttribute("seznam_position", seznam_position);
        model.addAttribute("google_position", google_position);
        model.addAttribute("centrum_position", centrum_position);
        model.addAttribute("pageName", "results");
        return "template";
	}

    public int getSeznamPosition(String url, String key, int number_of_pages)
    {
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

        return position;
    }
//    https://www.google.cz/search?q=auto.cz&start=10
    public int getGooglePosition(String url, String key, int number_of_pages)
    {
        Elements elements = HtmlParser.getElements("https://www.google.cz/search?q="+key+"&start=", 0, 10, number_of_pages, ".r a");
        List<String> links = HtmlParser.getAttributes(elements, "href");

        int position = 0;

        for (int i = 0; i < links.size(); i++)
        {
            if (links.get(i).contains(url))
            {
                position = i + 1;
            }
        }

        return position;
    }

    public int getCentrumPosition(String url, String key, int number_of_pages)
    {
        Elements elements = HtmlParser.getElements("http://search.centrum.cz/index.php?q="+key+"&from=", 0, 10, number_of_pages, "h3 a");
        List<String> links = HtmlParser.getAttributes(elements, "href");

        int position = 0;

        for (int i = 0; i < links.size(); i++)
        {
            if (links.get(i).contains(url))
            {
                position = i + 1;
            }
        }

        return position;
    }
}
