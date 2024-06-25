package concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentralLock {
    public static void main(String[] args) throws InterruptedException {
      //  Tasks task = new Tasks();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
              //  task.first();
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
              //  task.second();
            }
        });

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();
      //  task.show();

    }
}

class Task {
    private int counter;
    private Lock lock = new ReentrantLock();

    private void increment() {
        for (int i = 0; i < 10000; i++) {
            counter++;
        }
    }

    public void first() {
        lock.lock();
        increment();
        lock.unlock();
    }

    public void second() {
        lock.lock();
        increment();
        lock.unlock();
    }

    public void show() {
        System.out.println(counter);
    }
}

