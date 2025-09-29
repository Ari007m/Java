package vritual_thread;

public class ExecutorExample {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        threadLocal.set(Thread.currentThread().getName());

        Thread t1 = new Thread(() -> {
            threadLocal.set(Thread.currentThread().getName());
            System.out.println("Task 1");
        });

        t1.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main Thread: "+threadLocal.get());
    }
}
