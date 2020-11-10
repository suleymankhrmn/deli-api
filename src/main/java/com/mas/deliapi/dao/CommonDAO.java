package com.mas.deliapi.dao;

import java.util.List;

public interface CommonDAO<T> {

    T getById(long id);
    List<T> getList();
    List<T> getActives();
    void saveOrUpdate(T t);
    void delete(T t);





}
