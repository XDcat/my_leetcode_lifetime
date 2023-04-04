package com.zlj.concurrent.printnumber.lock.exercise.t4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new PrintNumber(0, null), "a");
        Thread t2 = new Thread(new PrintNumber(0, t1), "b");
        Thread t3 = new Thread(new PrintNumber(0,t2), "c");

        t1.start();
        t2.start();
        t3.start();
    }
}

class PrintNumber implements Runnable {
    private static int numMax = 10;
    private static int num = 0;
    private int index;
    private Thread preThread;

    public PrintNumber(int index, Thread preThread) {
        this.index = index;
        this.preThread = preThread;
    }

    @Override
    public void run() {
        if (preThread != null){
            try {
                preThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName());
    }
}
