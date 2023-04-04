package com.zlj.concurrent.printnumber.join.s1;

public class Main {
    public static void main(String[] args) {
        Thread a = new Thread(new PrintNumber(null, "A"));
        Thread b = new Thread(new PrintNumber(a, "B"));
        Thread c = new Thread(new PrintNumber(b, "C"));
        a.start();
        b.start();
        c.start();
    }
}

class PrintNumber implements Runnable {
    private Thread beforeThread;
    private String content;

    public PrintNumber(Thread beforeThread, String content) {
        this.beforeThread = beforeThread;
        this.content = content;
    }


    @Override
    public void run() {
        if (beforeThread != null) {
            try {
                beforeThread.join();
                System.out.println(content);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else{
            System.out.println(content);
        }
    }
}
