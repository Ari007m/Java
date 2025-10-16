package thread_intro;

public class ProcessThreadDemo {

    // ----------------------------------------------------
    // STEP 1: Process and Main Thread Identification
    // ----------------------------------------------------
    public static void identifyProcessAndMainThread() {
        // Get the current Process (JVM) ID (PID)
        long pid = ProcessHandle.current().pid();
        System.out.println("---------------------------------------------");
        System.out.println("   PROCESS CONTEXT (JVM) ESTABLISHED 💻 ");
        System.out.println("---------------------------------------------");
        System.out.println("-> Java Process ID (PID): " + pid);

        // Identify the first thread (the Main Thread)
        Thread currentThread = Thread.currentThread();
        System.out.println("-> Initial Thread Running: " + currentThread.getName());
        System.out.println("-> Initial Thread Priority: " + currentThread.getPriority());
        System.out.println("---------------------------------------------");
    }

    // ----------------------------------------------------
    // STEP 2: The Task Definition (What the threads will do)
    // ----------------------------------------------------
    // We use the Runnable interface for thread creation (best practice)
    static class WorkerTask implements Runnable {
        private String taskName;

        public WorkerTask(String name) {
            this.taskName = name;
        }

        @Override
        public void run() {
            // This code runs concurrently within the JVM Process
            Thread worker = Thread.currentThread();
            System.out.println("\n*** Starting Thread: " + worker.getName() + " for task: " + taskName + " ***");

            for (int i = 1; i <= 3; i++) {
                System.out.println("[" + worker.getName() + "] Progress: Step " + i);
                try {
                    // Simulate work with a short pause
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    System.out.println("[" + worker.getName() + "] was interrupted!");
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            System.out.println("*** Finished Thread: " + worker.getName() + " ***");
        }
    }

    // ----------------------------------------------------
    // STEP 3: Thread Creation and Execution
    // ----------------------------------------------------
    public static void main(String[] args) throws InterruptedException {

        // 1. Establish the Process Context
        identifyProcessAndMainThread();

        System.out.println("\n--- ADDING THREADS TO THE PROCESS FOR CONCURRENT EXECUTION ---");

        // 2. Define the tasks
        WorkerTask task1 = new WorkerTask("Data Processing");
        WorkerTask task2 = new WorkerTask("UI Rendering");

        // 3. Create Thread objects and assign names
        Thread workerA = new Thread(task1, "Worker-A");
        Thread workerB = new Thread(task2, "Worker-B");

        // 4. Start the Threads (moves them from NEW to RUNNABLE state)
        System.out.println("\n>>> Main Thread calls start() on Worker-A and Worker-B <<<");
        workerA.start();
        workerB.start();

        // 5. Wait for the new threads to complete (Optional, but good for cleanup)
        // The join() method ensures the Main Thread waits for these workers to finish.
        workerA.join();
        workerB.join();
        System.out.println("*** The Main thread waited for other threads to complete task and join ***");

        System.out.println("\n---------------------------------------------");
        System.out.println(">>> Main Thread execution resumes and ends. <<<");
        System.out.println("---------------------------------------------");
    }
}