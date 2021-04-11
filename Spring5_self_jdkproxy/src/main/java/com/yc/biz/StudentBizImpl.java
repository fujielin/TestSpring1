package com.yc.biz;

/**
 * @program: testSpring
 * @description:
 * @author: Bauer
 * @create: 2021-04-10 20:17
 */
public class StudentBizImpl implements StudentBiz{
    @Override
    public int add(String name) {
        System.out.println("调用了studentBizImpl中的add()"+name);
        return 100;
    }

    @Override
    public void update(String name) {
        System.out.println("调用了StudentBizImpl中的update()"+name);
    }

    @Override
    public String find(String name) {
        System.out.println("调用了studentBizImpl中的find()"+name);
        return name +"========";
    }
}
