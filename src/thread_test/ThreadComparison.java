package thread_test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadComparison {

    // --- Configuration ---
    private static final int NUMBER_OF_TASKS = 100_000;
    private static final long TASK_DELAY_MS = 1; // Simulate I/O waiting time (e.g., database query)
    private static final int PLATFORM_POOL_SIZE = 50; // Limited pool size for Platform Threads

    public static void main(String[] args) throws Exception {
        System.out.println("Starting Thread Comparison Test");
        System.out.println("Total Tasks: " + NUMBER_OF_TASKS + " | Task Delay (simulated I/O): " + TASK_DELAY_MS + " ms");
        System.out.println("---------------------------------------------------------");

        // Run the comparison tests
        long platformTime = runWithPlatformThreads();
        System.out.println("\n---------------------------------------------------------");
        long virtualTime = runWithVirtualThreads();

        // Print final results
        System.out.println("\n----------------------- RESULTS -------------------------");
        System.out.printf("1. Platform Threads (Pool Size %d): %d ms%n", PLATFORM_POOL_SIZE, platformTime);
        System.out.printf("2. Virtual Threads (Per Task Executor): %d ms%n", virtualTime);
        System.out.println("---------------------------------------------------------");
        System.out.println("Conclusion: Virtual Threads are significantly faster for I/O-bound workloads.");
    }

    // --- Implementation Methods ---

    /**
     * Runs all tasks using a limited pool of Platform Threads (traditional Java threads).
     * The limited pool size causes high queuing delay for the 100,000 tasks.
     */
    private static long runWithPlatformThreads() throws InterruptedException {
        long startTime = System.currentTimeMillis();

        // A limited pool of Platform Threads, typical for traditional services
        try (ExecutorService executor = Executors.newFixedThreadPool(PLATFORM_POOL_SIZE)) {
            System.out.println("Running with Platform Threads (Fixed Pool Size: " + PLATFORM_POOL_SIZE + ")...");

            for (int i = 0; i < NUMBER_OF_TASKS; i++) {
                executor.submit(ThreadComparison::performTask);
            }

            // Shutdown the executor and await the completion of all tasks
            executor.shutdown();
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.printf("Platform Threads completed in: %d ms%n", duration);
        return duration;
    }

    /**
     * Runs all tasks using Virtual Threads (one per task).
     * The tasks run with minimal overhead, leading to high throughput.
     */
    private static long runWithVirtualThreads() throws InterruptedException {
        long startTime = System.currentTimeMillis();

        // Virtual Thread Executor: creates a new virtual thread for every submitted task.
        // The try-with-resources handles both submission and waiting for completion.
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            System.out.println("Running with Virtual Threads (Per Task Executor)...");

            for (int i = 0; i < NUMBER_OF_TASKS; i++) {
                executor.submit(ThreadComparison::performTask);
            }

            // The executor will wait for all tasks submitted in the try-block to finish.
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.printf("Virtual Threads completed in: %d ms%n", duration);
        return duration;
    }

    /**
     * The I/O-bound task: a simple blocking operation that is executed by both thread types.
     */
    private static void performTask() {
        try {
            // Thread.sleep() simulates a blocking I/O operation (network call, database read)
            Thread.sleep(TASK_DELAY_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}