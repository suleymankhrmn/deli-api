package com.mas.deliapi.service;

import com.mas.deliapi.dao.CommonDAO;
import com.mas.deliapi.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;


public  class CommonServiceImpl<T extends BaseEntity> implements CommonService<T> {

    private CommonDAO<T> commonDAO;



    public CommonServiceImpl(CommonDAO<T> commonDAO) {
        this.commonDAO = commonDAO;
    }

    @Override
    @Transactional
    public T getById(long id) {
        return commonDAO.getById(id);
    }

    @Override
    @Transactional
    public List<T> getList() {
        return commonDAO.getList();
    }

    @Override
    @Transactional
    public List<T> getActives() {
        return commonDAO.getActives();
    }

    @Override
    @Transactional
    public void saveOrUpdate(T t) {
        commonDAO.saveOrUpdate(t);
    }

    @Override
    @Transactional
    public void delete(long id) {
        T item = commonDAO.getById(id);
        item.setActive(false);
        commonDAO.saveOrUpdate(item);
    }
}
