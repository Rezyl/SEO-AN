package com.ppro.spring.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ppro.spring.model.User;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 1.1.15
 */
@Repository
@Transactional
public class UserDAO extends AbstractDAO<User>{

    @Override
    public Class<User> getClazz() {
        return User.class;
    }

    public User getByName(String name) {
        Criteria criteria = getCurrentSession().createCriteria(getClazz());
        criteria.add(Restrictions.ilike("login", name));

        if (!criteria.list().isEmpty()) {
            //return first item because url column is unique
            return (User) criteria.list().get(0);
        }
        return null;
    }
}
