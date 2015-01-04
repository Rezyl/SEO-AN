package com.ppro.spring.service.impl;

import java.util.HashSet;
import java.util.Set;

import com.ppro.spring.dao.AbstractDAO;
import com.ppro.spring.service.api.CRUDService;

/**
 * Created with IntelliJ IDEA.
 * User: rezy
 * Date: 27.10.13
 */
public abstract class AbstractCRUDService<T> implements CRUDService<T> {

    protected abstract AbstractDAO<T> getDAOInstance();

    public T getByID(String id) {
        return getDAOInstance().getById(id);
    }

    public void save(T type) {
        getDAOInstance().save(type);
    }

    public void edit(T type){
        getDAOInstance().update(type);
    }

    public void delete(String id){
        getDAOInstance().deleteByID(id);
    }

    public Set<T> getAll(){
        Set<T> result = new HashSet<T>();
        for (T t : getDAOInstance().getAllItems()) {
            result.add(t);
        }
        return result;
    }

    public void deleteAll() {
        Set<T> items = getAll();
		for (T item : items) {
			getDAOInstance().deleteItem(item);
		}
    }

}
