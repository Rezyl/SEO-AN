package com.ppro.spring.service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 29.12.14
 */
public interface DaoService<T> {

    public T getByID(Long id);

    public void save(T type);

    public void edit(T type);

    public void delete(Long id);

    public List<T> getAll();

    public void deleteAll();
}
