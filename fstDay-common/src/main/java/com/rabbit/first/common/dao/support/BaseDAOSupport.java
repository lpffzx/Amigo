package com.rabbit.first.common.dao.support;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by Mr.Rabbit on 2017/3/29.
 */
public class BaseDAOSupport {
    @PersistenceContext
    private EntityManager entityManager;


    /**
     * 可用于创建JPQL查询
     *
     * @return
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

//    public void setEntityManager(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    /**
     * 可用于创建类型安全的条件查询
     *
     * @return
     */
    public CriteriaBuilder getCriteriaBuilder() {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        return cb;
    }

}
