package com.yc.starter.testmystarter_mysqlstarter;

import com.yc.starter.mysql_connectionspringbootstarter.DbHelper;
import com.yc.starter.mysql_connectionspringbootstarter.IDBHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;

@SpringBootApplication
@RestController
public class TestmystarterMysqlstarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestmystarterMysqlstarterApplication.class, args);
    }

    @Autowired
    private IDBHelper idbHelper;

    @GetMapping("/con")
    public String testcCon(){

        Connection con= idbHelper.getConnection();
        String conStr = con.toString();
        return conStr;
    }
}
