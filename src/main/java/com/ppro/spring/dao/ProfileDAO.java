package com.ppro.spring.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
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

    public Profile getByURL(String url) {
        Criteria criteria = getCurrentSession().createCriteria(getClazz());
        criteria.add(Restrictions.ilike("url", url));

        if (!criteria.list().isEmpty()) {
            //return first item because url column is unique
            return (Profile) criteria.list().get(0);
        }
    return null;
    }
}
