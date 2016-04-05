package com.marcus.threads;

/**
 * @author marcus
 */
public class ProducerConsumer1 {
    public static void main(String[] args) {
        CubbyHole1 c = new CubbyHole1();
        Producer1 p1 = new Producer1(c, 1);
        Consumer1 c1 = new Consumer1(c, 1);
        p1.start();
        c1.start();
    }
}
class CubbyHole1 {
    private int contents;

    public  int get() {


        return contents;
    }
    public  void put(int value) {

        contents = value;
    }
}

class Consumer1 extends Thread {
    private CubbyHole1 cubbyhole;
    private int number;
    public Consumer1(CubbyHole1 c, int number) {
        cubbyhole = c;
        this.number = number;
    }
    public void run() {
        int value = 0;
        for (int i = 0; i < 10; i++) {
            value = cubbyhole.get();
            System.out.println("Consumer #"
                    + this.number
                    + " got: " + value);
        }
    }
}

class Producer1 extends Thread {
    private CubbyHole1 cubbyhole;
    private int number;

    public Producer1(CubbyHole1 c, int number) {
        cubbyhole = c;
        this.number = number;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            cubbyhole.put(i);
            System.out.println("Producer #" + this.number
                    + " put: " + i);
            try {
                sleep((int)(Math.random() * 500));
            } catch (InterruptedException e) { }
        }
    }
}
