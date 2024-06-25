package pattern;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer w = new ProducerConsumer();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    w.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    w.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();

        t1.join();


    }
}

class ProducerConsumer {
    private Queue<Integer> queue = new LinkedList<>();
    private final int LIMIT = 10;
    private final Object lock = new Object();

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (lock) {
                while (queue.size() == LIMIT) {
                    lock.wait();
                }
                queue.offer(value++);
                lock.notify();
              //  System.out.println("Producet started");

            }
        }

    }

    public void consumer() throws InterruptedException {
        Thread.sleep(2000);
        Scanner s = new Scanner(System.in);
        while (true) {
            synchronized (lock) {
                while (queue.size() == 0) {
                    lock.wait();
                }
                int value = queue.poll();
                System.out.println(value);
                System.out.println("Queue sizq " + queue.size());
                lock.notify();
            }
            Thread.sleep(1000);
        }
    }
}
