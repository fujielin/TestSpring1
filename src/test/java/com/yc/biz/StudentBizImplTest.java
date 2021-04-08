package com.yc.biz;

import com.yc.AppConfig;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
因为这个类继承自TestCase，所以这个类为测试用例类，这个类中所有以test开头的方法都能成为测试方法，就不用加@Test注解
 */
public class StudentBizImplTest  {

    //容器
    ApplicationContext  ac;
    private StudentBizImpl studentBiz;

    @Before
    public void setup(){
        ac=new AnnotationConfigApplicationContext(AppConfig.class);
        studentBiz = (StudentBizImpl) ac.getBean("studentBizImpl");
    }
    @Test
    public void testAdd() {
        studentBiz.add("lisi");
    }
    @Test
    public void testUpdate() {
        studentBiz.update("lisi");
    }
}