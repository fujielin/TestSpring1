package com.yc.springboot2.helloStarter.controller;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: testSpring
 * @description:
 * @author: Bauer
 * @create: 2021-04-24 10:03
 */
@RestController
public class HelloWorldController {

    //创建按日志对象
    private static Log log = LogFactory.getLog(HelloWorldController.class);

    @Autowired
    private Environment evn;

    @Value("$yc.tname")
    private String tname;

    @Autowired
    private YcProperties yp;


    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        log.debug("-----------------debug");
        log.info(";;;;;;;;;;info");
        log.error("=============error");
        log.fatal("!!!!fatal");
        return String.format("Hello %s!", name);
    }
}
