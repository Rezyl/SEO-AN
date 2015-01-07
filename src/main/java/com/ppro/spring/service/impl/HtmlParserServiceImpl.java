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
	public int getPosition(String subject, String url, Integer numberOfPages, Server server) {
		Elements elements = getElements(server.getUrl(subject), server.getStart(), server.getIncrement(), numberOfPages, server.getElementSelection());
		List<String> links = getAttributeFromElements(elements, "href");

		for (int i = 0; i < links.size(); i++) {
			if (links.get(i).equals(url)) {
				return i + 1;
			}
		}
		return 0;
	}

    @Override
    public String checkHtmlValidity(String url) {

        String result;
        Element element = getElement("http://validator.w3.org/check?uri="+url, "td[class=valid]");

        if (element != null) {
            result = "Validní";
        }
        else {
            result = "Nevalidní";
        }
        return result;
    }

    public String checkCssValidity(String url) {

        String result;
        Element element = getElement("http://jigsaw.w3.org/css-validator/validator?uri="+url, "div[id=congrats]");

        if (element != null) {
            result = "Validní";
        }
        else {
            result = "Nevalidní";
        }
        return result;
    }

    private Element getElement(String url, String element_selection) {
        Element element = null;
        try {
            Document doc = Jsoup.connect(url).get();
            element = doc.select(element_selection).first();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return element;
    }

	private Elements getElements(String url, int start, int increment, int number_of_pages, String element_selection) {
		Elements elements = new Elements();
		try {
			for (int i = start; i < number_of_pages; i++) {
				Document doc = Jsoup.connect(url + (i * increment)).get();
				elements.addAll(doc.select(element_selection));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return elements;
	}

    private String getAttributeFromElement(Element element, String attribute_selection) {
        String attribute = element.attr(attribute_selection);

        return attribute;
    }

	private ArrayList<String> getAttributeFromElements(Elements elements, String attribute_selection) {
		ArrayList<String> attributes_array = new ArrayList<String>();

		for (int j = 0; j < elements.size(); j++) {
			String attribute = elements.get(j).attr(attribute_selection);
			attributes_array.add(attribute);
		}

		return attributes_array;
	}
}
