package com.zlj.concurrent.printnumber.lock.exercise.t2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PrintNumber p1 = new PrintNumber(0);
        PrintNumber p2 = new PrintNumber(1);
        PrintNumber p3 = new PrintNumber(2);

        Thread t1 = new Thread(p1, "a");
        Thread t2 = new Thread(p2, "b");
        Thread t3 = new Thread(p3, "c");
        t1.start();
        t2.start();
        t3.start();
    }
}

class PrintNumber implements Runnable {
    private static Object lock = new Object();
    private static int numMax = 10;
    private static int num = 0;
    private int index;

    public PrintNumber(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (lock) {
                while (num % 3 != index) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                num++;
                System.out.print(Thread.currentThread().getName());
                lock.notifyAll();
            }

        }
    }
}
