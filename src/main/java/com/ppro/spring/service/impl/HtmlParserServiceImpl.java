package com.ppro.spring.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import com.ppro.spring.model.Server;
import com.ppro.spring.service.api.HtmlParserService;

@Service
public class HtmlParserServiceImpl implements HtmlParserService {

    @Override
    public String checkHtmlValidity(String url) {
        String result;
        Element element_valid = null;
        Element element_invalid = null;

        Document doc = download("http://validator.w3.org/check?uri="+url);
        if (doc != null) {
            element_valid = doc.select("td[class=valid]").first();
        }

        if (doc != null) {
            element_invalid = doc.select("td[class=invalid]").first();
        }

        if (element_valid != null) {
            result = "Validní";
        }
        else if (element_invalid != null) {
            result = "Nevalidní";
        }
        else {
            result = "Nezjištěno";
        }

        return result;
    }

    @Override
    public String checkCssValidity(String url) {
        String result;
        Element element_valid = null;
        Element element_invalid = null;

        Document doc = download("http://jigsaw.w3.org/css-validator/validator?uri="+url);
        if (doc != null) {
            element_valid = doc.select("div[id=congrats]").first();
        }

        if (doc != null) {
            element_invalid = doc.select("div[id=errors]").first();
        }

        if (element_valid != null) {
            result = "Validní";
        }
        else if (element_invalid != null) {
            result = "Nevalidní";
        }
        else {
            result = "Nezjištěno";
        }

        return result;
    }

    @Override
    public String checkIndex(String url, String search_engine) {
        String result;
        Element element;

        if (search_engine.equals("google")) {
            Document doc = download("https://www.google.cz/search?q=site:"+url);
            if (doc != null) {
                element = doc.select("#resultStats").first();
                if (element != null) {
                    result = element.text().replace("Přibližný počet výsledků: ","");
                    int resind = result.indexOf("(");
                    if (resind > 0) {
                        result = result.substring(0,resind);
                    }
                }
                else {
                    result = "Nezjištěno";
                }
            }
            else {
                result = "Nezjištěno";
            }
        }
        else
        {
            Document doc = download("http://search.seznam.cz/?q=host:"+url);
            if (doc != null) {
                element = doc.select("#resultCount > strong:eq(2)").first();
                if (element != null) {
                    result = element.text();
                }
                else {
                    result = "Nezjištěno";
                }
            }
            else {
                result = "Nezjištěno";
            }
        }

        return result;
    }

    @Override
    public ArrayList<String> getMap(String url, int level) {
        ArrayList<String> map = new ArrayList<String>();
        Elements elements = new Elements();

        Document doc = download(url);
        if (doc != null) {
            elements.addAll(doc.select("a[href^="+url+"]:not([rel=nofollow])"));
            for (int j = 0; j < elements.size(); j++) {
                String attribute = elements.get(j).attr("href");
                map.add(attribute);

                if (level >= 0) {
                    level--;
                    map.addAll(getMap(url, level));
                }
            }
        }

        return map;
    }

    @Override
    public int getPosition(String subject, String url, Integer numberOfPages, Server server) {
        Elements elements = getElements(server.getUrl(subject), server.getStart(), server.getIncrement(), numberOfPages, server.getElementSelection());

        if (!elements.isEmpty()) {
            List<String> links = getAttributeFromElements(elements, "href");

            if (!links.isEmpty()) {
                for (int i = 0; i < links.size(); i++) {
                    if (links.get(i).contains(url)) {
                        return i + 1;
                    }
                }
            }
            return -2;
        }
        else {
            return -1;
        }
    }

	private Elements getElements(String url, int start, int increment, int number_of_pages, String element_selection) {
		Elements elements = new Elements();

		for (int i = start; i < number_of_pages; i++) {
            Document doc = download(url + (i * increment));
            if (doc != null) {
                elements.addAll(doc.select(element_selection));
            }
        }

		return elements;
	}

	private ArrayList<String> getAttributeFromElements(Elements elements, String attribute_selection) {
		ArrayList<String> attributes_array = new ArrayList<String>();

		for (int j = 0; j < elements.size(); j++) {
			String attribute = elements.get(j).attr(attribute_selection);
			attributes_array.add(attribute);
		}

		return attributes_array;
	}

    // stažení dokumentu z URL
    private Document download(String url) {

        try {
            Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.3; rv:36.0) Gecko/20100101 Firefox/36.0").referrer("http://www.google.com").get();
            return doc;
        } catch (IOException e) {
            return null;
        }

    }
}