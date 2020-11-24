package com.mas.deliapi.service;

import com.mas.deliapi.dao.CommonDAO;
import com.mas.deliapi.entity.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public  class BaseServiceImpl extends CommonServiceImpl<Base> {
    @Autowired
    public BaseServiceImpl(CommonDAO<Base> commonDAO) {
        super(commonDAO);
    }
}
