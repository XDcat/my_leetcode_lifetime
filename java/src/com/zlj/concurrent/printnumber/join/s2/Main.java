package com.zlj.concurrent.printnumber.join.s2;

public class Main {
    public static void main(String[] args) {
        PrintNumber pa = new PrintNumber(null, "A");
        Thread a = new Thread(pa);
        PrintNumber pb = new PrintNumber(a, "B");
        Thread b = new Thread(pb);
        PrintNumber pc = new PrintNumber(b, "C");
        Thread c = new Thread(pc);
        pa.setBeforeThread2(c);
        a.start();
        b.start();
        c.start();
    }
}

class PrintNumber implements Runnable {
    private Thread beforeThread;
    private Thread beforeThread2;
    private String content;

    public void setBeforeThread2(Thread beforeThread2) {
        this.beforeThread2 = beforeThread2;
    }

    public PrintNumber(Thread beforeThread, String content) {
        this.beforeThread = beforeThread;
        this.content = content;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (beforeThread != null) {
                try {
                    beforeThread.join();
                    System.out.println(content);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(content);
                beforeThread = beforeThread2;
            }
        }
    }
}
