package com.yc.starter.testmystarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class TestmystarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestmystarterApplication.class, args);
    }

    @GetMapping("/hello")
    public void hello(){
        System.out.println("hello");
    }

}
