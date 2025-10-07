package thread_test;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class CpuIntensiveComparison {

    // --- Configuration ---
    // The number of tasks is reduced for CPU-intensive work to keep the test duration reasonable.
    private static final int NUMBER_OF_TASKS = 2000;
    // A high number of iterations to simulate heavy computation
    private static final int CPU_ITERATIONS = 500_000_000;
    // Optimal platform pool size: number of cores (or slightly more)
    private static final int PLATFORM_POOL_SIZE = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) throws Exception {
        System.out.println("Starting CPU-Intensive Task Comparison Test 🧑‍💻");
        System.out.println("Total Tasks: " + NUMBER_OF_TASKS + " | Iterations per Task: " + CPU_ITERATIONS);
        System.out.println("Optimal Platform Pool Size (Cores): " + PLATFORM_POOL_SIZE);
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
        System.out.println("Conclusion: Platform Threads are generally better suited for CPU-bound workloads,");
        System.out.println("            as limiting thread count prevents excessive scheduling overhead.");
    }

    // --- Implementation Methods ---

    /**
     * Runs all tasks using a limited pool of Platform Threads (traditional Java threads).
     * This setup is optimized for CPU-bound work by limiting threads to the number of cores.
     */
    private static long runWithPlatformThreads() throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        Future<Long> result = null;

        try (ExecutorService executor = Executors.newFixedThreadPool(PLATFORM_POOL_SIZE)) {
            System.out.println("Running with OPTIMIZED Platform Threads...");

            for (int i = 0; i < NUMBER_OF_TASKS; i++) {
               result = executor.submit(CpuIntensiveComparison::performCpuTask);
            }

            // Shutdown the executor and await the completion of all tasks
            executor.shutdown();
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.printf("Platform Threads completed in: %d ms%n", duration);
        System.out.println("The sum is : "+ result.get());
        return duration;
    }

    /**
     * Runs all tasks using Virtual Threads (one per task).
     * This will create many more runnable threads than there are cores, introducing scheduling overhead.
     */
    private static long runWithVirtualThreads() throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        Future<Long> result = null;
        // Creates a new virtual thread for every submitted task (2000 threads)
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            System.out.println("Running with Virtual Threads (Per Task Executor)...");

            for (int i = 0; i < NUMBER_OF_TASKS; i++) {
                result = executor.submit(CpuIntensiveComparison::performCpuTask);
            }
        } // Executor waits for all tasks to finish here


        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.printf("Virtual Threads completed in: %d ms%n", duration);
        System.out.println("The sum is : "+ result.get());
        return duration;
    }

    /**
     * The CPU-bound task: performs a heavy calculation (many iterations of a loop).
     */
    private static long performCpuTask() {
        // A simple, heavy calculation loop (e.g., calculating a large sum)
        long sum = 0;
        for (int i = 0; i < CPU_ITERATIONS; i++) {
            sum += i;
        }
        // Use the result to ensure the compiler doesn't optimize away the entire loop
        if (sum < 0) {
            System.out.print("");
        }

        return sum;
    }
}