package com.rabbit.first.dao.appstore;

import com.rabbit.first.dao.common.ZlBaseDao;
import com.rabbit.first.domain.appstore.ZlAppDO;

/**
 * Created by Mr.Rabbit on 2017/6/22.
 */
public interface ZlAppDAO extends ZlBaseDao<ZlAppDO, Integer> {
    Integer step1();

    void step2(Integer id);

    void step3(Integer id);

}
