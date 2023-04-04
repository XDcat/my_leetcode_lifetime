package com.zlj.concurrent.printnumber.lock.exercise.t5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Condition c1 = PrintNumber.getCondition();
        Condition c2 = PrintNumber.getCondition();
        Condition c3 = PrintNumber.getCondition();


        PrintNumber p1 = new PrintNumber(0, c1, c2);
        PrintNumber p2 = new PrintNumber(1, c2, c3);
        PrintNumber p3 = new PrintNumber(2, c3, c1);

        Thread t1 = new Thread(p1, "a");
        Thread t2 = new Thread(p2, "b");
        Thread t3 = new Thread(p3, "c");
        t1.start();
        t2.start();
        t3.start();
    }
}

class PrintNumber implements Runnable {
    private static Lock lock = new ReentrantLock();
    private static int numMax = 10;
    private static int num = 0;
    private int index;
    private Condition curCondition;
    private Condition nextCondition;

    public PrintNumber(int index, Condition curCondition, Condition nextCondition) {
        this.index = index;
        this.curCondition = curCondition;
        this.nextCondition = nextCondition;
    }

    public static Condition getCondition() {
        return lock.newCondition();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            lock.lock();
            try {
                while (num % 3 != index) {
                    curCondition.await();
                }
                num++;
                System.out.println("" + Thread.currentThread().getName() + "->" + num);
                nextCondition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
