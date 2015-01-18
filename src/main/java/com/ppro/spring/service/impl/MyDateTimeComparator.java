package com.ppro.spring.service.impl;

import java.util.Comparator;

import org.joda.time.DateTimeComparator;

import com.ppro.spring.model.SearchResult;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 18.1.15
 */
public class MyDateTimeComparator implements Comparator<SearchResult> {
    @Override
    public int compare(SearchResult o1, SearchResult o2) {
        return DateTimeComparator.getInstance().compare(o2.getCreationDate(), o1.getCreationDate());
    }
}
