package com.sumant.boot.learning;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.xml.ws.RequestWrapper;

@FeignClient(name= "springboot-apiserver-service", fallback = APIServerFallback.class)
public interface APIServer {

    @RequestMapping(method= RequestMethod.GET, value="/data")
    String getData();
}

