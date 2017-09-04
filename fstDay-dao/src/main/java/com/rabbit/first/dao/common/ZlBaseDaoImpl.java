package com.rabbit.first.dao.common;


import com.rabbit.first.common.dao.support.BaseDAOSupport;

import javax.persistence.LockModeType;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import static javax.persistence.LockModeType.*;

/**
 * Created by Mr.Rabbit on 2017/5/18.
 */
public abstract class ZlBaseDaoImpl<T, ID extends Serializable> extends BaseDAOSupport implements ZlBaseDao<T, ID> {

    private Class<T> entityClass;

    public ZlBaseDaoImpl() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass = (Class) params[0];
    }

    private CriteriaQuery<T> createCriteriaQuery() {
        return getCriteriaBuilder().createQuery(getEntityClass());
    }


    public Class<T> getEntityClass() {
        return entityClass;
    }

    @Override
    public void delete(T model) {

    }

    @Override
    public void deleteById(ID id) {
    }

    @Override
    public void joinTransaction() {
        if (!getEntityManager().isJoinedToTransaction())
            getEntityManager().joinTransaction();
    }

    @Override
    public T getById(ID id) {
        return getById(id, NONE);
    }

    @Override
    public T getById(ID id, LockModeType lockModeType) {
        return getEntityManager().find(getEntityClass(), id, lockModeType);
    }

    @Override
    public T getReferenceById(ID id) {
        return getEntityManager().getReference(getEntityClass(), id);
    }

    @Override
    public List<T> list() {
        CriteriaQuery<T> c = getCriteriaBuilder().createQuery(getEntityClass());
        c.select(c.from(getEntityClass()));
        return getEntityManager().createQuery(c).getResultList();
    }

    @Override
    public Long getCount() {
        CriteriaQuery<Long> c =
                getCriteriaBuilder().createQuery(Long.class);
        c.select(getCriteriaBuilder().count(c.from(getEntityClass())));
        return getEntityManager().createQuery(c).getSingleResult();
    }

    @Override
    public T makePersistent(T entity) {
        return getEntityManager().merge(entity);
    }

    @Override
    public void makeTransient(T entity) {
        getEntityManager().remove(entity);
    }


    @Override
    public void checkVersion(T entity, boolean forceUpdate) {
        getEntityManager().lock(entity, forceUpdate ? OPTIMISTIC_FORCE_INCREMENT : OPTIMISTIC);
    }


    protected void addEq(CriteriaQuery<T> cri, Root<T> r, String propertyName, Object t) {
        cri.where(getCriteriaBuilder().equal(r.get(propertyName), t));
    }
}
