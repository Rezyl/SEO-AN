package com.ppro.spring.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.ppro.spring.model.Server;
import com.ppro.spring.service.api.HtmlParserService;

@Service
public class HtmlParserServiceImpl implements HtmlParserService {

	@Override
	public int getPosition(String subject, String url, Integer numberOfPages, Server server) {
		Elements elements = getElements(server.getUrl(subject), server.getStart(), server.getIncrement(), numberOfPages, server.getElementSelection());
		List<String> links = getAttributes(elements, "href");

		for (int i = 0; i < links.size(); i++) {
			if (links.get(i).equals(url)) {
				return i + 1;
			}
		}
		return 0;
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

	private ArrayList<String> getAttributes(Elements elements, String attribute_selection) {
		ArrayList<String> attributes_array = new ArrayList<String>();

		for (int j = 0; j < elements.size(); j++) {
			String attribute = elements.get(j).attr(attribute_selection);
			attributes_array.add(attribute);
		}

		return attributes_array;
	}
}
