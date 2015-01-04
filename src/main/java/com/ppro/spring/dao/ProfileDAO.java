package com.ppro.spring.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ppro.spring.model.Profile;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 1.1.15
 */
@Repository
@Transactional
public class ProfileDAO extends AbstractDAO<Profile>{

    @Override
    public Class<Profile> getClazz() {
        return Profile.class;
    }
}
