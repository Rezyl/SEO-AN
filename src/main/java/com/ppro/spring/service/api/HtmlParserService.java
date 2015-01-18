package com.ppro.spring.service.api;

import com.ppro.spring.model.Server;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 3.1.15
 */
public interface HtmlParserService {

    public int getPosition(String subject, String url, Integer numberOfPages, Server server);
    public String checkHtmlValidity(String url);
    public String checkCssValidity(String url);
    public String checkIndex(String url, String search_engine);
    public ArrayList<String> getMap(String url, int level);
}
