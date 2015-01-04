package com.ppro.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppro.spring.dao.AbstractDAO;
import com.ppro.spring.dao.SearchResultDAO;
import com.ppro.spring.model.SearchResult;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 4.1.15
 */
@Service("SearchResultService")
public class SearchResultServiceImpl extends AbstractCRUDService<SearchResult> {

    @Autowired
    private SearchResultDAO searchResultDAO;

    @Override
    protected AbstractDAO<SearchResult> getDAOInstance() {
        return searchResultDAO;
    }
}
