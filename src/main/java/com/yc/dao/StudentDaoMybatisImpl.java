package com.yc.dao;

import org.springframework.stereotype.Repository;

import java.util.Random;

/**
 * @program: testSpring
 * @description:
 * @author: Bauer
 * @create: 2021-04-04 15:32
 */
@Repository//异常转化  ：从Exception转为RuntimeException
public class StudentDaoMybatisImpl implements StudentDao {

    public int add(String name) {
        System.out.println("mybatis 添加学生：" + name);
        Random r = new Random();

        return r.nextInt();
    }

    public void update(String name) {
        System.out.println("Mybatis 更新学生：" + name);
    }
}
