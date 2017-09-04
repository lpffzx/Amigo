package com.rabbit.first.dao.common;

import javax.persistence.LockModeType;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Mr.Rabbit on 2017/5/18.
 */
public interface ZlBaseDao<T, ID extends Serializable> extends Serializable {


    void delete(T model);

    void deleteById(ID id);

    /**
     *
     */
    void joinTransaction();

    /**
     * @param id
     * @return
     */
    T getById(ID id);

    /**
     * @param id
     * @param lockModeType
     * @return
     */
    T getById(ID id, LockModeType lockModeType);

    /**
     * @param id
     * @return
     */
    T getReferenceById(ID id);

    /**
     * @return
     */
    List<T> list();

    /**
     * @return
     */
    Long getCount();

    /**
     * @param entity
     * @return
     */
    T makePersistent(T entity);

    /**
     * @param entity
     */
    void makeTransient(T entity);

    /**
     * @param entity
     * @param forceUpdate
     */
    void checkVersion(T entity, boolean forceUpdate);
}
