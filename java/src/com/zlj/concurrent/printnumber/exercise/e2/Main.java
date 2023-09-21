package com.zlj.concurrent.printnumber.exercise.e2;

import java.util.concurrent.Semaphore;

/**
 * @author Lianjie Zeng <zenglianjie@foxmail.com>
 * Created on 2023-07-29
 */
public class Main {
    public static void main(String[] args) {
        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(0);
        Printer p1 = new Printer(s1, s2);
        Printer p2 = new Printer(s2, s1);

        new Thread(p1, "A").start();
        new Thread(p2, "B").start();
    }
}

class Printer implements Runnable {
    private static int CUR = 0;
    private static int MAX = 10;

    private Semaphore cur;  // 当前信号量
    private Semaphore next;  // 下一个信号量

    public Printer(Semaphore cur, Semaphore next) {
        this.cur = cur;
        this.next = next;
    }

    @Override
    public void run() {
        while (true){
            try {
                cur.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (CUR >= MAX){
                break;
            }

            System.out.printf("%d: %s\n", CUR, Thread.currentThread().getName());
            CUR++;
            next.release();

            if (CUR >= MAX){
                break;
            }
        }
    }
}
