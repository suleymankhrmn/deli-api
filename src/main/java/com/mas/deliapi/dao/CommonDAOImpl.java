package com.mas.deliapi.dao;

import com.mas.deliapi.entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public abstract class CommonDAOImpl<T extends BaseEntity> implements CommonDAO<T>  {

    private Class<T> type;

    @PersistenceContext
    private EntityManager entityManager;


    @Autowired
    public CommonDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public T getById(long id) {
        Session session = entityManager.unwrap(Session.class);

        return (T)session.get(type,id);
    }

    @Override
    public List<T> getList() {
        return null;
    }

    @Override
    public List<T> getActives() {
        Session session = entityManager.unwrap(Session.class);
        Query<T> query = session.createQuery("");
        return  null;
    }

    @Override
    public void saveOrUpdate(T t) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(t);

    }

    @Override
    public void delete(T t) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(t);
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<T> type) {
        this.type = type;
    }
}
