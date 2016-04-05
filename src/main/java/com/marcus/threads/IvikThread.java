package com.marcus.threads;

/**
 * @author marcus
 */


class  MyIvikThread extends Thread {

    public void run(){
        System.out.println("thread");
    }


}
public class IvikThread {


    public static void main(String[] args) {

      Runnable r1 = new Runnable(){

          @Override
          public void run() {
              System.out.println("runnable ");
          }
      };

     MyIvikThread t1 = new MyIvikThread();
     t1.start();

        System.out.println("in main");

        Thread t2 = new Thread(r1);

        t2.start();



    }

}
