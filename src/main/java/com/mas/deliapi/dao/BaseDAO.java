package com.mas.deliapi.dao;

import com.mas.deliapi.entity.Base;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class BaseDAO extends CommonDAOImpl<Base> {
    public BaseDAO(EntityManager entityManager) {

        super(entityManager);
        setType(Base.class);

    }
}
