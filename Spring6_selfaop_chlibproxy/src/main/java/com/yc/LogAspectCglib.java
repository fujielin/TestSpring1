package com.yc;

import com.sun.org.apache.xpath.internal.Arg;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @program: testSpring
 * @description:
 * @author: Bauer
 * @create: 2021-04-10 20:47
 */
public class LogAspectCglib implements MethodInterceptor {
    private Object target;
    public LogAspectCglib(Object target){
        this.target = target;
    }
    public Object createProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if (method.getName().startsWith("add")){
            log();
        }
        Object returnValue = method.invoke(this.target,args);

        return returnValue;
    }

    private void log() {
        System.out.println("======before advice======");
        System.out.println("hello ,this is "+new Date());
        System.out.println("=============" +
                "");
    }
}
