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
	public ArrayList<String> getDataFromURL(String url, String selection)
	{
		Document doc;
		try
		{
			doc = Jsoup.connect(url).get();
			Elements links = doc.select(selection);
			ArrayList<String> data_array = new ArrayList<String>();

			for(int i=0; i<links.size(); i++)
			{
				String para = links.get(i).html();
				data_array.add(para);
		    }

			return data_array;
		}
		catch (IOException e)
		{
			e.printStackTrace();
			ArrayList<String> data_array = new ArrayList<String>();
			return data_array;
		}
	}
	
	public String getParam(String url, String selection)
	{
		Document doc;
		try
		{
			doc = Jsoup.connect(url).get();
			String param = doc.select(selection).html();
			return param;
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return "";
		}
	}
	
	public ArrayList<String> getLinks(String url, String selection)
	{
		Document doc;

		try
		{
			doc = Jsoup.connect(url).get();
			Elements links = doc.select(selection);
			ArrayList<String> links_array = new ArrayList<String>();

			for(int i=0; i<links.size(); i++)
			{
				String para = links.get(i).attr("href");
				links_array.add(para);
		    }

			return links_array;
		}
		catch (IOException e)
		{
			e.printStackTrace();
			ArrayList<String> links_array = new ArrayList<String>();
			return links_array;
		}

	}

}
