package com.gxs.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/customer")
public class CustomerController {
//    private static final String REST_URL_PREFIX="http://localhost:8001";
    /**
     * 注册再EurekaServer中的微服务名称
     */
    private static final String REST_URL_PREFIX="http://microservicecloud-dept";
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        System.out.println("111");
        return restTemplate.getForObject(REST_URL_PREFIX+"/study/test",String.class);
    }
    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery(){
        return  restTemplate.getForObject(
                REST_URL_PREFIX+"/dept/discovery",
                Object.class);
    }
}
