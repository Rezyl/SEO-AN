package com.ppro.spring.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ppro.spring.model.SearchResult;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 1.1.15
 */
@Repository
@Transactional
public class SearchResultDAO extends AbstractDAO<SearchResult>{

    @Override
    public Class<SearchResult> getClazz() {
        return SearchResult.class;
    }
}
