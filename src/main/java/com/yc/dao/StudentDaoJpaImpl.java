package com.yc.dao;

import org.springframework.stereotype.Repository;

import java.util.Random;

/**
 * @program: testSpring
 * @description:
 * @author: Bauer
 * @create: 2021-04-04 14:47
 */
@Repository
public class StudentDaoJpaImpl implements  StudentDao  {
    public int add(String name) {
        System.out.println("jpa 添加学生："+ name);
        Random r = new Random();

        return r.nextInt();
    }

    public void update(String name) {
        System.out.println("jpa 更新学生："+name);
    }
}
