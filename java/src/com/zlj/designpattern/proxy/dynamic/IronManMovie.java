package com.zlj.designpattern.proxy.dynamic;

public class IronManMovie implements Movie{
    @Override
    public void play() {
        System.out.println("Play IRON MAN!");
    }
}
