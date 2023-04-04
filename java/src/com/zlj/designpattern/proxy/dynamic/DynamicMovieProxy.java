package com.zlj.designpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicMovieProxy implements InvocationHandler {
    private Object object;

    public DynamicMovieProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Hello, before movie.");
        Object invoke = method.invoke(object, args);
        System.out.println("Hello, after movie.");
        return invoke;
    }
}
