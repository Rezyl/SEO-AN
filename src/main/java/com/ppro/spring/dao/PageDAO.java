package com.ppro.spring.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ppro.spring.model.Page;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 1.1.15
 */
@Repository
@Transactional
public class PageDAO extends AbstractDAO<Page>{

    @Override
    public Class<Page> getClazz() {
        return Page.class;
    }
}
