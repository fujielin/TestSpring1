package com.yc.biz;

/**
 * @program: testSpring
 * @description:
 * @author: Bauer
 * @create: 2021-04-10 20:45
 */
public class StudentBizImpl {
    public int add(String name){
        System.out.println("调用了studentBizImpl中的add"+name);
        return 100;
    }
    public void update(String name) {
        System.out.println("调用了StudentBizImpl中的update()"+name);
    }
    public String find(String name) {
        System.out.println("调用了studentBizImpl中的find()"+name);
        return name +"========";
    }
}
