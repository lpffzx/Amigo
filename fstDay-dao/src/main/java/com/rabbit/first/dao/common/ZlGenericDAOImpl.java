package com.rabbit.first.dao.common;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.LockModeType.*;

/**
 * Created by Mr.Rabbit on 2017/6/22.
 */
public abstract class ZlGenericDAOImpl<T, ID extends Serializable> implements ZlGenericDAO<T, ID> {

    protected final EntityManager em;
    protected final Class<T> entityClass;

    public ZlGenericDAOImpl(EntityManager em, Class<T> entityClass) {
        this.em = em;
        this.entityClass = entityClass;
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public CriteriaBuilder getCriteriaBuilder() {
        return em.getCriteriaBuilder();
    }

    @Override
    public void joinTransaction() {
        if (!em.isJoinedToTransaction())
            em.joinTransaction();
    }

    @Override
    public T getById(ID id) {
        return getById(id, NONE);
    }

    @Override
    public T getById(ID id, LockModeType lockModeType) {
        return em.find(entityClass, id, lockModeType);
    }

    @Override
    public T getReferenceById(ID id) {
        return em.getReference(entityClass, id);
    }

    @Override
    public List<T> list() {
        CriteriaQuery<T> c = getCriteriaBuilder().createQuery(entityClass);
        c.select(c.from(entityClass));
        return em.createQuery(c).getResultList();
    }

    @Override
    public Long getCount() {
        CriteriaQuery<Long> c =
                getCriteriaBuilder().createQuery(Long.class);
        c.select(getCriteriaBuilder().count(c.from(entityClass)));
        return em.createQuery(c).getSingleResult();
    }

    @Override
    public T makePersistent(T entity) {
        return em.merge(entity);
    }

    @Override
    public void makeTransient(T entity) {
        em.remove(entity);
    }

    @Override
    public void checkVersion(T entity, boolean forceUpdate) {
        em.lock(entity, forceUpdate ? OPTIMISTIC_FORCE_INCREMENT : OPTIMISTIC);
    }
}
