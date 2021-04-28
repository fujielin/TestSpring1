package com.yc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringbootBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBankApplication.class, args);
    }

}
