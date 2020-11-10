package com.mas.deliapi.service;

import com.mas.deliapi.dao.CommonDAO;
import com.mas.deliapi.entity.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public  class BaseServiceImpl implements CommonService<Base> {

    private CommonDAO<Base> commonDAO;

    @Autowired
    public BaseServiceImpl(CommonDAO<Base> commonDAO) {
        this.commonDAO = commonDAO;
    }


    @Override
    @Transactional
    public Base getById(long id) {
        return commonDAO.getById(id);
    }

    @Override
    @Transactional
    public List<Base> getList() {
        return null;
    }

    @Override
    @Transactional
    public List<Base> getActives() {
        return null;
    }

    @Override
    @Transactional
    public void saveOrUpdate(Base base) {
        commonDAO.saveOrUpdate(base);
    }

    @Override
    @Transactional
    public void delete(long id) {
        Base base = commonDAO.getById(id);
        base.setActive(false);
        commonDAO.saveOrUpdate(base);
    }
}
