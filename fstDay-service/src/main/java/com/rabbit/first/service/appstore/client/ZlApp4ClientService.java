package com.rabbit.first.service.appstore.client;

import com.rabbit.first.dto.appstore.params.ZlAppQueryDTO;
import com.rabbit.first.domain.appstore.ZlAppDO;

/**
 * Created by Mr.Rabbit on 2017/6/22.
 */
public interface ZlApp4ClientService {

    /**
     * @param queryDTO
     * @return
     */
    ZlAppDO getById(ZlAppQueryDTO queryDTO);

    /**
     * @param entity
     * @return
     */
    ZlAppDO save(ZlAppDO entity);

    /**
     * @param queryDTO
     */
    void deleteById(ZlAppQueryDTO queryDTO);


    /**
     * @param queryDTO
     * @return
     */
    ZlAppDO getReferenceById(ZlAppQueryDTO queryDTO);

    /**
     * @param entity
     */
    void delete(ZlAppDO entity);

    void test();
}
