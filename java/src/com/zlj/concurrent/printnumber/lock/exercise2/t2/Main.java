package com.zlj.concurrent.printnumber.lock.exercise2.t2;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(0);
        Semaphore s3 = new Semaphore(0);
        PrintNumber p1 = new PrintNumber(s1, s2);
        PrintNumber p2 = new PrintNumber(s2, s3);
        PrintNumber p3 = new PrintNumber(s3, s1);
        Thread t1 = new Thread(p1, "A");
        Thread t2 = new Thread(p2, "B");
        Thread t3 = new Thread(p3, "C");

        t1.start();
        t2.start();
        t3.start();
    }
}

class PrintNumber implements Runnable {
    public static int MAX = 10;
    public static int NUM = 0;
    private Semaphore curSem;
    private Semaphore nextSem;

    public PrintNumber(Semaphore curSem, Semaphore nextSem) {
        this.curSem = curSem;
        this.nextSem = nextSem;
    }

    @Override
    public void run() {
       while (NUM <= MAX) {
           try{
               curSem.acquire();
               if (NUM > MAX){
                   nextSem.release();
                   break;
               }
               System.out.println(Thread.currentThread().getName());
               NUM++;
               nextSem.release();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}
