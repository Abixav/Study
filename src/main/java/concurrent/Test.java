package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.submit(new Proccesor(countDownLatch, i));
        }
        executorService.shutdown();
        for (int i = 0; i< 3;i++) {
            Thread.sleep(1000);
            countDownLatch.countDown();
        }
    }
}

class Proccesor implements Runnable {
    private CountDownLatch countDownLatch;
    private int id;

    public Proccesor(CountDownLatch countDownLatch, int id) {
        this.countDownLatch = countDownLatch;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread with id" + id);

    }
}
