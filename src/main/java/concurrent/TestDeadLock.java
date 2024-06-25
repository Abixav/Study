package concurrent;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestDeadLock {
    public static void main(String[] args) throws InterruptedException {
        Runner runner = new Runner();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.first();
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.second();
            }
        });
        thread.start();
        thread1.start();

        thread.join();
        thread1.join();
        runner.finished();
    }
}

class Runner {
    private Account acc1 = new Account();
    private Account acc2 = new Account();
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();
    Random random = new Random();

    private void takeLocks(Lock lock1, Lock lock2) {
        boolean firstLock = false;
        boolean secondLock = false;
        while (true) {
            try {
                firstLock = lock1.tryLock();
                secondLock = lock2.tryLock();
            } finally {
                if (firstLock && secondLock) {
                    return;
                }
                if (firstLock) {
                    lock1.unlock();
                }
                if (secondLock) {
                    lock2.unlock();
                }
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void first() {
        for (int i = 0; i < 10000; i++) {
          /*  lock1.lock();
            lock2.lock();*/
            takeLocks(lock1, lock2);

            try {
                Account.transfer(acc1, acc2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void second() {
        for (int i = 0; i < 10000; i++) {
           /* lock1.lock();
            lock2.lock();*/
            takeLocks(lock2, lock1);


            try {
                Account.transfer(acc2, acc1, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finished() {
        System.out.println(acc1.getBalance());
        System.out.println(acc2.getBalance());
        System.out.println("Total nalance: " + (acc1.getBalance() + acc2.getBalance()));
    }
}

class Account {
    private int balance = 10000;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withRaw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public static void transfer(Account acc1, Account acc2, int amount) {
        acc1.withRaw(amount);
        acc2.deposit(amount);
    }
}
