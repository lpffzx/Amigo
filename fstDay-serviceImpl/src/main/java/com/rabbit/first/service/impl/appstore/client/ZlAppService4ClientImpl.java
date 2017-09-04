package com.rabbit.first.service.impl.appstore.client;

import com.rabbit.first.dao.appstore.ZlAppDAO;
import com.rabbit.first.dto.appstore.params.ZlAppQueryDTO;
import com.rabbit.first.domain.appstore.ZlAppDO;
import com.rabbit.first.service.appstore.client.ZlApp4ClientService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * Created by Mr.Rabbit on 2017/6/22.
 */
@Service
@Transactional
public class ZlAppService4ClientImpl implements ZlApp4ClientService {
    @Autowired
    ZlAppDAO appDAO;

    @Override
    public ZlAppDO getById(ZlAppQueryDTO queryDTO) {
        ZlAppDO result = appDAO.getById(queryDTO.getId());
        return result;
    }

    @Override
    public ZlAppDO save(ZlAppDO entity) {
        return appDAO.makePersistent(entity);
    }


    @Override
    public void deleteById(ZlAppQueryDTO queryDTO) {
        appDAO.makeTransient(getById(queryDTO));
    }

    @Override
    public void delete(ZlAppDO entity) {
        entity = appDAO.makePersistent(entity);
        appDAO.makeTransient(entity);
    }

    @Override
    public void test() {
        Integer id = appDAO.step1();
        appDAO.step2(id);
        try {
            Executors.newSingleThreadExecutor().submit(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    appDAO.step3(id);
                    return null;
                }
            }).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ZlAppDO getReferenceById(ZlAppQueryDTO queryDTO) {
        ZlAppDO appRef = appDAO.getReferenceById(queryDTO.getId());
        Hibernate.initialize(appRef);
//        ZlAppDTO result = new ZlAppDTO();
//        result.setId(appRef.getId());
//        result.setTitle(appRef.getTitle());
//        result.setPackageName(appRef.getPackageName());
        return appRef;
    }
}
