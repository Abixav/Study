package concurrent;

import java.util.Random;

public class TestInteraptedException {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 100000000; i++) {
                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("Thread interrupted");
                        break;
                    }
                    Math.sin(random.nextDouble());
                }
            }
        });
        System.out.println("Starting");

        thread.start();

        Thread.sleep(1000);
        thread.interrupt();

        thread.join();


        System.out.println("Finished");
    }
}
