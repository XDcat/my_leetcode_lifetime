package com.zlj.concurrent.printnumber.lock.exercise2.t1;

public class Main {
    public static void main(String[] args) {
        PrintNumber p1 = new PrintNumber(0);
        PrintNumber p2 = new PrintNumber(1);
        PrintNumber p3 = new PrintNumber(2);

        Thread t1 = new Thread(p1, "A");
        Thread t2 = new Thread(p2, "B");
        Thread t3 = new Thread(p3, "C");

        t1.start();
        t2.start();
        t3.start();
    }
}

class PrintNumber implements Runnable{
    public static int MAX=10;
    public static int NUM=0;
    public static int N=3;
    public static final Object lock = new Object();
    private int i;

    public PrintNumber(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true){
            synchronized (lock){
                while (NUM % N != i){
                    if (NUM > MAX){
                        break;
                    }
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (NUM > MAX){
                    break;
                }

                System.out.println(Thread.currentThread().getName());
                NUM ++;
                lock.notifyAll();
            }
        }
    }
}