package com.gxs.springcloud.controller;

import com.gxs.springcloud.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xuyaoyao
 * @Description:
 * @Date: Create in 14:31 2019/10/24
 */
@RestController
public class StudyController {
    @Autowired
    private StudyService studyService;
    @RequestMapping("test")
    public String test(){
        return studyService.test();
    }
}
