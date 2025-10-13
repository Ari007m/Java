package thread_intro;

/**
 * Implementation in Java (The "Code")
 * Demonstrates the two primary ways to create threads and key control methods.
 */
public class ThreadImplementationDemo {

    // Method 1: Implementing Runnable
    static class TaskRunnable implements Runnable {
        private String taskName;

        public TaskRunnable(String name) {
            this.taskName = name;
        }

        @Override
        public void run() {
            // The code that defines the task
            System.out.println(Thread.currentThread().getName() + " STARTED task: " + taskName);
            try {
                // Thread Control Method: sleep() - moves thread to TIMED_WAITING state
                System.out.println(taskName + ": Sleeping for 300ms...");
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // Thread Control Method: interrupt() - handles interruption request
                System.out.println(taskName + " was interrupted.");
                Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread().getName() + " FINISHED task: " + taskName);
        }
    }

    // Method 2: Extending Thread
    static class TaskThread extends Thread {
        public TaskThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(this.getName() + " (Extending Thread) is running.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Demonstration of Thread Creation and start() vs. run()

        // A. Creating a thread using Runnable
        TaskRunnable cleanupTask = new TaskRunnable("SystemCleanup");
        Thread t1 = new Thread(cleanupTask, "T1-Cleanup");

        // B. Creating a thread by extending Thread
        TaskThread t2 = new TaskThread("T2-Extension");

        System.out.println("--- Starting Concurrent Execution with start() ---");

        // start(): Executes t1 concurrently in a NEW thread
        t1.start();

        // start(): Executes t2 concurrently in a NEW thread
        t2.start();

        // C. Demonstrating the effect of join()
        // Main thread waits for T1 to finish its job before proceeding
        System.out.println("\nMain Thread waiting for T1-Cleanup to join...");
        // Thread Control Method: join() - moves main thread to WAITING state
        t1.join();
        System.out.println("Main Thread resumed after T1-Cleanup finished.");

        System.out.println("\n Demonstrating Synchronous run() ");

        // D. Calling run() directly: Executes the task synchronously in the MAIN thread
        TaskRunnable synchronousTask = new TaskRunnable("SynchronousTask");
        // NOTE: No new thread is created! The code executes sequentially in the Main thread.
        synchronousTask.run();

        System.out.println("---> Main Thread finished execution. <---");
    }
}
