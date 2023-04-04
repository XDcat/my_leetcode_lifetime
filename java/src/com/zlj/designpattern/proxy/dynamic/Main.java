package com.zlj.designpattern.proxy.dynamic;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Movie ironManMovie = new IronManMovie();
        System.out.println("------ Static Proxy ------");
        Movie movieProxy = new MovieProxy(ironManMovie);
        movieProxy.play();


        System.out.println("------ Dynamic Proxy ------");
        DynamicMovieProxy dynamicMovieProxy = new DynamicMovieProxy(ironManMovie);
        Movie dynamicProxy = (Movie) Proxy.newProxyInstance(IronManMovie.class.getClassLoader(), IronManMovie.class.getInterfaces(), dynamicMovieProxy);
        dynamicProxy.play();
    }
}
