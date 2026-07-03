package topics.thread_test;

public class ThreadRaceCondition {
    static int count = 0;
//    static final Object lock = new Object();

    private static synchronized void increment(){
        count++;
    }

    private static int getCount(){
        return count;
    }

    static void main() throws InterruptedException {

//        ThreadRaceCondition obj = new ThreadRaceCondition();
        Runnable task = () -> {
            for (int i = 0; i < 1000000; i++){
                    increment();
            }
        };

        Thread one = new Thread(task);
        Thread two = new Thread(task);

        one.start();
        two.start();

        one.join();
        two.join();

        System.nanoTime();
        System.out.println(getCount());

    }
}
