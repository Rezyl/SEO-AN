package com.ppro.spring.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ppro.spring.model.Server;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 29.12.14
 */
@Repository
@Transactional
public class ServerDAO extends AbstractDAO<Server> {
    @Override
    public Class<Server> getClazz() {
        return Server.class;
    }
}
