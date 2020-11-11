package com.mas.deliapi.service;

import com.mas.deliapi.dao.CommonDAO;
import com.mas.deliapi.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommonServiceImpl<T extends BaseEntity> implements CommonService<T> {
    private CommonDAO<T> commonDAO;

    @Autowired
    public CommonServiceImpl(CommonDAO<T> commonDAO) {
        this.commonDAO = commonDAO;
    }

    @Override
    public T getById(long id) {
        return commonDAO.getById(id);
    }

    @Override
    public List<T> getList() {
        return commonDAO.getList();
    }

    @Override
    public List<T> getActives() {
        return commonDAO.getActives();
    }

    @Override
    public void saveOrUpdate(T t) {
        commonDAO.saveOrUpdate(t);
    }

    @Override
    public void delete(long id) {
        T item = commonDAO.getById(id);
        item.setActive(false);
        commonDAO.saveOrUpdate(item);
    }
}
