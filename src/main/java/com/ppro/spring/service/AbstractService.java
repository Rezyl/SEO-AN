package com.ppro.spring.service;

import java.util.List;

import com.ppro.spring.dao.AbstractDAO;

/**
 * Created with IntelliJ IDEA.
 * User: rezy
 * Date: 27.10.13
 */
public abstract class AbstractService<T,T_DAO extends AbstractDAO<T>> implements DaoService<T> {

    private final T_DAO dao;

    AbstractService(T_DAO dao) {
        this.dao = dao;
    }

    public T getByID(Long id) {
        return dao.getById(id);
    }

    public void save(T type) {
        dao.save(type);
    }

    public void edit(T type){
        dao.update(type);
    }

    public void delete(Long id){
        dao.deleteByID(id);
    }

    public List<T> getAll(){
        return dao.getAllItems();
    }

    public void deleteAll() {
        List<T> items = getAll();
		for (T item : items) {
			dao.deleteItem(item);
		}
    }

}
