package com.yc.biz;

import com.yc.AppConfig;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: testSpring
 * @description:
 * @author: Bauer
 * @create: 2021-04-04 15:50
 */
public class HelloWorldTest extends TestCase {//测试用例
    private ApplicationContext ac;//spring容器

    @Override
    @Before
    public void setUp() {

        ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //读取 AppConfig.class  -》basePackage->"com.yc" -> 得到要扫描的路径
        //要检查这些包中的上是否有@Companent注解， 如有，则实例化
        //存到一个Map<String,Object>   ==ac
    }

    @Test
    public void testHello() {
        HelloWorld hw = (HelloWorld) ac.getBean("helloWorld");
        hw.hello();
        //spring容器是单例模型

    }
}
