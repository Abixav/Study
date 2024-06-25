package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestQuickSort {

    public static void main(String[] args) throws InterruptedException {
       // int[] arr = new int[]{4, 2, 6, 1};
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for(int i = 0; i < 5; i++)
            executorService.submit(new Work(i));

        executorService.shutdown();
        System.out.println("All tasks submitted");
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}
class Work implements Runnable {
    private int id;
    public Work(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Work " + id + " was completed ");
    }
}
