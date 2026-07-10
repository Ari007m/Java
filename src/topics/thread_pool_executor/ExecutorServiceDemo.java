package topics.thread_pool_executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {

    static void main() {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 20; i++) {
            int taskOf = i;
            executorService.submit(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(STR."Task Number: \{taskOf} - Current thread name: \{Thread.currentThread().getName()}");
            });
        }

        executorService.shutdown();
    }
}
