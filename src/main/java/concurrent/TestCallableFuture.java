package concurrent;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.*;

public class TestCallableFuture {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> future = executorService.submit(()->{
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Random random = new Random();
            int randomValue = random.nextInt(10);
            if (randomValue < 5)  {
                throw new Exception("S/th bad");
            }
            return random.nextInt(10);
        });
        executorService.shutdown();
        try {
            int result = future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            Throwable ex = e.getCause();
            System.out.println(ex.getMessage());
        }

    }
}
