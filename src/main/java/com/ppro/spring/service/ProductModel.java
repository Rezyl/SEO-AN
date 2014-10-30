package com.ppro.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductModel
{
    @Autowired
	public HtmlParserService html_parser;
	
	public ArrayList<String> getProductLinks(String url, String selection)
	{
		ArrayList<String> data = html_parser.getLinks(url, selection);
		return data;
	}
	
	public ArrayList<String> getProducts(ArrayList<String> product_links, String selection)
	{
		ArrayList<String> products = new ArrayList<String>();
		
		for(int i=0; i<product_links.size(); i++)
		{
			String link = product_links.get(i);
			String product_name = html_parser.getParam(link, selection);
			products.add(product_name);
	    }
		System.out.print(products);	
		return products;
	}

}
