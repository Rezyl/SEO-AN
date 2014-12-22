package com.ppro.spring.service;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class HtmlParserService
{
    public Elements getElements(String url, int start, int increment, int number_of_pages, String element_selection)
    {
        Elements elements = new Elements();
        try
        {
            for(int i=start; i<number_of_pages; i++)
            {
                Document doc = Jsoup.connect(url + (i*increment)).get();
                elements.addAll(doc.select(element_selection));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return elements;
    }

    public ArrayList<String> getAttributes(Elements elements, String attribute_selection)
    {
        ArrayList<String> attributes_array = new ArrayList<String>();

        for (int j = 0; j < elements.size(); j++)
        {
            String attribute = elements.get(j).attr(attribute_selection);
            attributes_array.add(attribute);
        }

        return attributes_array;
    }
}
