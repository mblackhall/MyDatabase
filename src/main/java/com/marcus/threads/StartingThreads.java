package com.marcus.threads;

/**
 * @author marcus
 */


class AThread extends Thread {

    public void run(){

        for (int i=0; i< 10; i++){


            System.out.println("calculating with " + i + " : " + getName());

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Thread interupted");
            }
        }

    }

}



public class StartingThreads {


    public static void main(String[] args) throws InterruptedException {

        AThread thread1 = new AThread();
        thread1.setName("thread1");
        AThread thread2 = new AThread();
        thread2.setName("thread2");
        Runnable r1 = new Runnable (){


            @Override
            public void run() {

                System.out.println("thread with runnable");
            }
        };

        Thread thread3 = new Thread(r1,"thread3");


        thread1.start();
        thread2.start();
        thread3.start();



    }


}
