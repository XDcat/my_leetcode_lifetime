package com.zlj.jvm;

public class NativeDemo {
    public static void main(String[] args) {
        new Thread(() -> {

        }, "My Thread").start();
    }
    /*
    native ?
    凡是带有 native 关键字的，说明 java 的作用范围达不到了，会去调用 C 语言的方法库。
    * 会进入本地方法栈 -> 会进入本地方法接口（JNI）
        * JNI: java native interface，java 本地接口。
        * JNI 的作用，扩展 java 的使用，融合不同的编程语言位 java 所用！ 最初是希望与 C 和 C++ 融合。
        * 为什么要融合？ 因为 java 诞生的时候，C 和 C++ 横行，为了能够立足于市场，必须要融合。
        * 在内存区域中专门开辟了一块标记区域： Native Method Stack，登记 native 方法，最终执行的时候，通过 JNI 加载本地方法库中的方法。
        * 例如 java 程序驱动程序、管理系统等，但是在企业级应用中比较少见。
     */
    public native void hello();
}
