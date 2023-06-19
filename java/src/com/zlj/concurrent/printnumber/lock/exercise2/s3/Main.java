package com.zlj.concurrent.printnumber.lock.exercise2.s3;

public class Main {
   public static void main(String[] args) {
      PrintNumber p1 = new PrintNumber(null);
      Thread t1 = new Thread(p1, "A");
      PrintNumber p2 = new PrintNumber(t1);
      Thread t2 = new Thread(p2, "B");
      PrintNumber p3 = new PrintNumber(t2);
      Thread t3 = new Thread(p3, "C");
      p1.setNext(t3);

      t1.start();
      t2.start();
      t3.start();
   }
}

class PrintNumber implements Runnable{
   public static int MAX = 10;
   public static int NUM = 0;
   private Thread before, next;

   public PrintNumber(Thread before) {
      this.before = before;
   }

   public void setNext(Thread next) {
      this.next = next;
   }

   @Override
   public void run() {
      for (int i = 0; i < MAX; i++) {
         if (before != null){
            try {
               before.join();
               System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         } else {
            System.out.println(Thread.currentThread().getName());
            before = next;
         }
      }
   }
}