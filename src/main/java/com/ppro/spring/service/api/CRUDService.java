package com.ppro.spring.service.api;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 29.12.14
 */
public interface CRUDService<T> {

    public T getByID(Long id);

    public void save(T type);

    public void edit(T type);

    public void delete(Long id);

    public Set<T> getAll();

    public void deleteAll();
}
