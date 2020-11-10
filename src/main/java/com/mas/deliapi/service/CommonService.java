package com.mas.deliapi.service;

import java.util.List;

public interface CommonService<T> {

    T getById(long id);
    List<T> getList();
    List<T> getActives();
    void saveOrUpdate(T t);
    void delete(long id);



}
