package com.zlj.jvm.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Lianjie Zeng <zenglianjie@foxmail.com>
 * Created on 2023-09-05
 */
public class Main {
    public static void main(String[] args) {
        TVShow tvShow = new TVShow();
        Handler handler = new Handler(tvShow);
        Show tvShowHandler = (Show) Proxy.newProxyInstance(TVShow.class.getClassLoader(), TVShow.class.getInterfaces(), handler);
        tvShowHandler.show();
    }
}

interface Show {
    void show();
}
class TVShow implements Show{
    @Override
    public void show() {
        System.out.println("TVShow");
    }
}
class Handler implements InvocationHandler {
    private Object target;
    public Handler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("pre invoke");
        Object invoke = method.invoke(target, args);
        System.out.println("after invoke");
        return invoke;
    }
}
