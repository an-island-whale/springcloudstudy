package com.gxs.springcloud.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: xuyaoyao
 * @Description:
 * @Date: Create in 15:20 2019/11/7
 */
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory<StudyService> {

    @Override
    public StudyService create(Throwable cause) {
        return new StudyService() {
            @Override
            public String test() {
                return "降级服务的返回值";
            }
        };
    }
}
