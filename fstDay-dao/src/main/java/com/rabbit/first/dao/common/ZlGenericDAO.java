package com.rabbit.first.dao.common;

import javax.persistence.LockModeType;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Mr.Rabbit on 2017/6/22.
 */
public interface ZlGenericDAO<T, ID extends Serializable> extends Serializable {

    void joinTransaction();

    T getById(ID id);

    T getById(ID id, LockModeType lockModeType);

    T getReferenceById(ID id);

    List<T> list();

    Long getCount();

    T makePersistent(T entity);

    void makeTransient(T entity);

    void checkVersion(T entity, boolean forceUpdate);

}
