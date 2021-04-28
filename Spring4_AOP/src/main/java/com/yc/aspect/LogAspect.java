package com.yc.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: testSpring
 * @description: lin
 * @author: Bauer
 * @create: 2021-04-10 16:33
 */


@Aspect  //切面类：你要增强的功能
@Component  //IOC注解：以实现让spring托管
public class LogAspect {

    @Around("execution(* com.yc.biz.StudentBizImpl.find*(..))")
    public Object compute(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("=========compute进到  增强了。。。");
        long start = System.currentTimeMillis();
        Object retVal = pjp.proceed();//目标类的目标方法
        long end = System.currentTimeMillis();
        System.out.println("compute要退出增强了");
        System.out.println("这个方法运行时长为：" + (end - start));
        return retVal;
    }

    //切入点的声明  pointcut signature
    @Pointcut("execution(* com.yc.biz.StudentBizImpl.add(..))")// the pointcut expression(切入点表达式)：哪些方法上增强
    private void add() {

    }

    @Pointcut("execution(* com.yc.biz.StudentBizImpl.update(..))")// the pointcut expression(切入点表达式)：哪些方法上增强
    private void update() {

    }

    @Pointcut("execution(* com.yc.biz.StudentBizImpl.find(..))")// the pointcut expression(切入点表达式)：哪些方法上增强
    private void find() {

    }

    @Pointcut("add()||update()||find()")
    private void addAndUpdateAndFind() {

    }


    //切入点表达式的语法：
    //  ?代表出现0次或者1次
    //  modifiers-pattern：修饰衔
    //  ret-type-pattern：返回类型
    //  declaring-type-pattern：声明类型
    //  name-pattern：名字模式
    //  throws-pattern：抛出异常模式（型）
    //  param-pattern：参数模式
    // execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern)
    //                throws-pattern?)


    //增强的声明
    @Before("com.yc.aspect.LogAspect.addAndUpdateAndFind()")
    public void log() {
        System.out.println("=====前置增强的日志=====");
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dser = sdf.format(d);
        System.out.println(dser);
        System.out.println("=====前置增强的日志over=====");

    }

}
