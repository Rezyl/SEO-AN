package com.ppro.spring.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bot
{
	Map<String,String> config;
	private ArrayList<String> routes = new ArrayList<String>();
	private ArrayList<String> products = new ArrayList<String>();
    @Autowired
	public ProductModel product_model;

    public void setConfig(Map<String, String> config) {
        this.config = config;
    }

    public ArrayList<String> run()
	{
		getNewRoutes();
		products = getNewProducts();
		return products;
	}

	public void getNewRoutes()
	{
		String url = config.get("url");
		routes.add(url);
		
		String paging_url  = config.get("paging_url");
		int max_page = Integer.parseInt(config.get("max_page"));
		
		for(int i = 1; i <= max_page; i++)
		{
			routes.add(url + paging_url + i);
	    }
	}
	
	public ArrayList<String> getNewProducts()
	{
		String product_link = config.get("product_link");
		
		ArrayList<String> product_links = new ArrayList<String>();;
		
		for(int i=0; i<routes.size(); i++)
		{
			String url = routes.get(i);
			ArrayList<String> product_links_temp = product_model.getProductLinks(url, product_link);
			product_links.addAll(product_links_temp);
	    }

		products = product_model.getProducts(product_links, config.get("product_name"));
		return products;
	}

	public String move()
	{
		if (routes.size() > 0)
		{
			routes.remove(0);
			return routes.get(0);
		}
		else
		{
			return "";
		}
	}
}
