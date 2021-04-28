package com.yc;

import com.yc.biz.StudentBizImpl;

/**
 * @program: testSpring
 * @description:
 * @author: Bauer
 * @create: 2021-04-10 20:55
 */
public class Test {
    public static void main(String[] args) {
        StudentBizImpl sbi = new StudentBizImpl();

        LogAspectCglib lc = new LogAspectCglib(sbi);

        //生成代理
        Object obj = lc.createProxy();
        System.out.println(obj);
        if (obj instanceof StudentBizImpl) {
            StudentBizImpl s = (StudentBizImpl) obj;

            s.find("张三");
            s.update("李四");
            s.add("王五");
        }
    }
}
