package com.zlj.concurrent.printnumber.lock.exercise.t6;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(0);
        Semaphore s3 = new Semaphore(0);


        PrintNumber p1 = new PrintNumber(0, s1, s2);
        PrintNumber p2 = new PrintNumber(1, s2, s3);
        PrintNumber p3 = new PrintNumber(2, s3, s1);

        Thread t1 = new Thread(p1, "a");
        Thread t2 = new Thread(p2, "b");
        Thread t3 = new Thread(p3, "c");
        t1.start();
        t2.start();
        t3.start();
    }
}

class PrintNumber implements Runnable {
    private static int numMax = 10;
    private static int num = 0;
    private int index;
    private Semaphore curCondition;
    private Semaphore nextCondition;

    public PrintNumber(int index, Semaphore curCondition, Semaphore nextCondition) {
        this.index = index;
        this.curCondition = curCondition;
        this.nextCondition = nextCondition;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                curCondition.acquire();
                num++;
                System.out.println("" + Thread.currentThread().getName() + "->" + num);
                nextCondition.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
