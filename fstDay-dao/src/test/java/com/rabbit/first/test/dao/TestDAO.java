package com.rabbit.first.test.dao;

import com.rabbit.first.common.dao.support.BaseDAOSupport;
import com.rabbit.first.domain.appstore.ZlAppDO;
import org.testng.annotations.Test;

import javax.transaction.Transactional;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

import static org.testng.Assert.assertEquals;


public class TestDAO extends BaseDAOSupport {


    @Test
    @Transactional
    public void firstCommitWins() {
        ZlAppDO someApp = new ZlAppDO();
        someApp.setTitle("some app");
        System.out.println("dssd" + getEntityManager());
        getEntityManager().persist(someApp);
        System.out.println("if transaction===" + getEntityManager().isJoinedToTransaction());
        getEntityManager().getTransaction().commit();
        getEntityManager().close();
        final Integer ITEM_ID = someApp.getId();
        getEntityManager().joinTransaction();
        ZlAppDO newApp = getEntityManager().find(ZlAppDO.class, ITEM_ID);
        assertEquals(newApp.getVersion(), 0);
        newApp.setTitle("new app");
        try {
            Executors.newSingleThreadExecutor().submit(new Callable<Object>() {

                @Override
                public Object call() throws Exception {
                    ZlAppDO otherApp = getEntityManager().find(ZlAppDO.class, ITEM_ID);
                    assertEquals(otherApp.getVersion(), 0);
                    otherApp.setTitle("other app");
                    getEntityManager().getTransaction().commit();
                    getEntityManager().close();
                    return null;
                }
            }).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        getEntityManager().flush();


    }

}
