package com.gxs.springcloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: xuyaoyao
 * @Description:
 * @Date: Create in 14:24 2019/10/24
 */
@FeignClient(value = "microservicecloud-dept",fallbackFactory = DeptClientServiceFallBackFactory.class)
public interface StudyService {
    @RequestMapping(value = "/study/test",method = RequestMethod.GET)
    public String test();
}
