package com.rabbit.first.controller.appstore.client;

import com.rabbit.first.common.constant.UTF8MediaType;
import com.rabbit.first.dto.appstore.params.ZlAppQueryDTO;
import com.rabbit.first.domain.appstore.ZlAppDO;
import com.rabbit.first.service.appstore.client.ZlApp4ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * Created by Mr.Rabbit on 2017/6/22.
 */
@Controller
@Path("/client/app")
public class ZlApp4ClientController {
    @Autowired
    ZlApp4ClientService app4ClientService;

    @POST
    @Path("/get")
    @Consumes(UTF8MediaType.JSON)
    @Produces(UTF8MediaType.JSON)
    public Object getApp(@Context UriInfo ui, @Context HttpServletRequest request, ZlAppQueryDTO queryDTO) {
        return app4ClientService.getById(queryDTO);
    }

    @POST
    @Path("save")
    @Consumes(UTF8MediaType.JSON)
    @Produces(UTF8MediaType.JSON)
    public Object saveApp(@Context UriInfo ui, @Context HttpServletRequest request, ZlAppDO entity) {
        return app4ClientService.save(entity);
    }

    @POST
    @Path("deleteById")
    @Consumes(UTF8MediaType.JSON)
    @Produces(UTF8MediaType.JSON)
    public Object deleteApp(@Context UriInfo ui, @Context HttpServletRequest request, ZlAppQueryDTO queryDTO) {
        app4ClientService.deleteById(queryDTO);
        return "ok";
    }

    @POST
    @Path("delete")
    @Consumes(UTF8MediaType.JSON)
    @Produces(UTF8MediaType.JSON)
    public Object deleteApp(@Context UriInfo ui, @Context HttpServletRequest request, ZlAppDO entity) {
        app4ClientService.delete(entity);
        return "ok";
    }

    @POST
    @Path("/getRef")
    @Consumes(UTF8MediaType.JSON)
    @Produces(UTF8MediaType.JSON)
    public Object getAppRef(@Context UriInfo ui, @Context HttpServletRequest request, ZlAppQueryDTO queryDTO) {
        return app4ClientService.getReferenceById(queryDTO);
    }


    @POST
    @Path("/test")
    @Consumes(UTF8MediaType.JSON)
    @Produces(UTF8MediaType.JSON)
    public Object test(@Context UriInfo ui, @Context HttpServletRequest request) {
        app4ClientService.test();
        return "ok";
    }


}
