package com.ppro.spring.service.api;

import com.ppro.spring.model.Server;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 3.1.15
 */
public interface HtmlParserService {

    public int getPosition(String subject, String url, Integer numberOfPages, Server server);
}
