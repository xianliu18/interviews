package com.noodles.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.noodles.provider.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName HelloController
 * @Description 控制层
 * @Author noodles
 * @Date 2021/3/12 15:16
 */
@Controller
public class HelloController {

    @Reference
    HelloService helloService;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(String name) {
        System.out.println("请求参数:" + name);
        return helloService.sayHello(name);
    }
}
