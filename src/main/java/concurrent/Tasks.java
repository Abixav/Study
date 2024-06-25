package concurrent;

public class Tasks implements Runnable {
   static int count = 1;
    int MAX = 12;
    int rem;
    static Object object = new Object();

    public Tasks(int rem) {
        this.rem = rem;
    }

    @Override
    public void run() {
        while (count < MAX - 1) {
            synchronized (object) {
                while (count % 3 != rem) {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "  " +count);
                count++;
                object.notifyAll();
            }

        }
    }


    public static void main(String[] args) {
        Tasks tasks = new Tasks(1);
        Tasks tasks1 = new Tasks(2);
        Tasks tasks2 = new Tasks(0);
        Thread thread1 = new Thread(tasks, "T1");
        Thread thread2 = new Thread(tasks1, "T2");
        Thread thread3 = new Thread(tasks2, "T3");
        thread1.start();
        thread2.start();
        thread3.start();

       /* try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }
}

