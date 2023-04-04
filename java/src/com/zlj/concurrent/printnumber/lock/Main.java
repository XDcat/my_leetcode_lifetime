package com.zlj.concurrent.printnumber.lock;

public class Main {
    public static void main(String[] args) {
        PrintNumber.N = 3;
        PrintNumber.NUM = 0;
        PrintNumber.MAX = 100;

        new Thread(new PrintNumber(0, "A")).start();
        new Thread(new PrintNumber(1, "B")).start();
        new Thread(new PrintNumber(2, "C")).start();
    }
}

class PrintNumber implements Runnable {
    public static int NUM;
    public static int N;
    public static int MAX;
    private static final Object lock = new Object();
    private String s;
    private int i;

    public PrintNumber(int i, String s) {
        this.s = s;
        this.i = i;
    }

    @Override
    public void run() {
        while (true){
            synchronized (lock) {
                while (NUM % N != i) {
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
                System.out.println(s + NUM);
                NUM++;
                lock.notifyAll();
            }
        }
    }
}
