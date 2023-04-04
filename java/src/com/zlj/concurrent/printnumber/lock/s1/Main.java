package com.zlj.concurrent.printnumber.lock.s1;

public class Main {
    public static void main(String[] args) {
        PrintNumber.N = 3;
        new Thread(new PrintNumber(0, "A")).start();
        new Thread(new PrintNumber(1, "B")).start();
        new Thread(new PrintNumber(2, "C")).start();
    }
}

class PrintNumber implements Runnable{
    public static int num;
    public static int N;
    private static final Object lock = new Object();
    private String s;
    private int i;
    public PrintNumber(int i, String s){
        this.s = s;
        this.i = i;
    }

    @Override
    public void run() {
        synchronized (lock){
            while (num % N != i){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            num ++;
            System.out.println(s);
            lock.notifyAll();
        }
    }
}
