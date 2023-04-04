package com.zlj.concurrent.printnumber.lock.s2;

public class Main {
    public static void main(String[] args) {
        PrintNumber.N = 3;
        PrintNumber.NUM = 0;
        PrintNumber.COUNT = 10;

        new Thread(new PrintNumber(0, "A")).start();
        new Thread(new PrintNumber(1, "B")).start();
        new Thread(new PrintNumber(2, "C")).start();
    }
}

class PrintNumber implements Runnable {
    public static int NUM;
    public static int N;
    public static int COUNT;
    private static final Object lock = new Object();
    private String s;
    private int i;

    public PrintNumber(int i, String s) {
        this.s = s;
        this.i = i;
    }

    @Override
    public void run() {
        for (int j = 0; j < COUNT; j++) {
            synchronized (lock) {
                while (NUM % N != i) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(s);
                NUM++;
                lock.notifyAll();
            }
        }
    }
}
