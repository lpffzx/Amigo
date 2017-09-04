package com.rabbit.first.common.rest;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

/**
 * Created by date13 on 15/3/10.
 */
public class RestJaxRsApplication extends ResourceConfig {
    public RestJaxRsApplication() {

        register(RequestContextFilter.class);
        register(JacksonFeature.class);
        register(MultiPartFeature.class);
    }
}
