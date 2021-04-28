package com.yc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * @program: testSpring
 * @description:
 * @author: Bauer
 * @create: 2021-04-10 20:23
 */
public class LogAspect implements InvocationHandler {
    private Object target;//目标类的对象

    public LogAspect(Object target) {
        this.target = target;
    }

    public Object createProxy() {
        //           新建一个代理实例
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理类的对象：" + proxy.getClass());
        System.out.println("目标类的方法：" + method);
        System.out.println("方法中的参数：：" + args);

        if (method.getName().startsWith("add")) {//转换成切入点表达式的解析  ——》 AspectJ的切入点表达式
            //前置增强
            log();
        }
        Object returnValue = method.invoke(this.target, args);//相当于直接执行了  StudentBizImpl中的find()
        //后置增强
        return returnValue;

    }

    private void log() {
        System.out.println("======before advice======");
        System.out.println("hello ,this is " + new Date());
        System.out.println("=============" +
                "");
    }
}
