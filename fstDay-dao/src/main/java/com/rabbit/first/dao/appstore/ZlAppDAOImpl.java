package com.rabbit.first.dao.appstore;

import com.rabbit.first.dao.common.ZlBaseDaoImpl;
import com.rabbit.first.domain.appstore.ZlAppDO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Mr.Rabbit on 2017/6/22.
 */
@Component
public class ZlAppDAOImpl extends ZlBaseDaoImpl<ZlAppDO, Integer> implements ZlAppDAO {


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer step1() {
        ZlAppDO someApp = new ZlAppDO();
        someApp.setTitle("some app");
        getEntityManager().persist(someApp);
        System.out.println("if transaction===" + getEntityManager().isJoinedToTransaction());
        final Integer ITEM_ID = someApp.getId();
        System.out.println("app id===" + ITEM_ID);
        return ITEM_ID;

    }

    @Override
    @Transactional
    public void step2(Integer id) {
        ZlAppDO newApp = getEntityManager().find(ZlAppDO.class, id);
        System.out.println("newApp version====" + newApp.getVersion());
        newApp.setTitle("new app");
    }

    @Override
    @Transactional
    public void step3(Integer id) {
        ZlAppDO otherApp = getEntityManager().find(ZlAppDO.class, id);
        System.out.println("otherApp version====" + otherApp.getVersion());
        otherApp.setTitle("other app");
    }


}
