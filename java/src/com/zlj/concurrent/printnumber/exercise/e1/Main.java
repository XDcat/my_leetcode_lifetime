package com.zlj.concurrent.printnumber.exercise.e1;

/**
 * @author Lianjie Zeng <zenglianjie@foxmail.com>
 * Created on 2023-07-29
 */
public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Printer(0), "A");
        Thread t2 = new Thread(new Printer(1), "B");

        t1.start();
        t2.start();
    }
}


class Printer implements Runnable{
    private static Object lock = new Object();  // 锁对象
    private static int N = 2;  // 线程数量
    private static int CUR = 0;  // 当前数字
    private static int END = 10;  // 最大数字
    private int n;  // 线程编号

    public Printer(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        // 死循环，直到 CUR >= END
        while (true){
            synchronized (lock){
                // 直到符合条件，才继续执行下面的内容
                while (CUR % N != n){
                    if (CUR >= END){
                        return;
                    }
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (CUR >= END){
                    return;
                }

                // 执行命令，并唤醒其他线程
                System.out.printf("%d: %s\n", CUR, Thread.currentThread().getName());
                CUR++;
                lock.notifyAll();
            }

        }
    }
}
