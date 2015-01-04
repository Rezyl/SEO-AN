package com.ppro.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public abstract class AbstractDAO<T> {

	@Autowired
	protected SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public T getById(String id) {
		return (T) getCurrentSession().get(getClazz(), id);
	}

	public abstract Class<T> getClazz();

    protected Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

	@SuppressWarnings("unchecked")
	public List<T> getAllItems() {
		Criteria criteria = getCurrentSession().createCriteria(
				getClazz());
		return criteria.list();
	}

	public void save(T type) {
		getCurrentSession().save(type);
	}

	public void update(T type) {
		getCurrentSession().merge(type);
	}

	public void deleteByID(String id) {
		T t = getById(id);
		getCurrentSession().delete(t);
	}

    public void deleteItem(T type) {
        getCurrentSession().delete(type);
    }
}
