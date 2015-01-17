package com.ppro.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppro.spring.dao.AbstractDAO;
import com.ppro.spring.dao.PageDAO;
import com.ppro.spring.model.Page;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 4.1.15
 */
@Service("PageService")
public class PageServiceImpl extends AbstractCRUDService<Page> {

    @Autowired
    private PageDAO pageDAO;

    @Override
    protected AbstractDAO<Page> getDAOInstance() {
        return pageDAO;
    }
}
