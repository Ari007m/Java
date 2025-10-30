package process_thread_demo;

class ByRunnable implements Runnable{
// This Class implements runnable which has single method
    public void run() {
        for(int i=0;i<=15;i++){
            System.out.println("This is ByRunnable");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class ByExtends extends Thread{

    public ByExtends(String name) {
        super(name);
    }

    public void run() {
        for(int i=0;i<=10;i++){
            System.out.println("This is By Extending Thread Clas");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class MultiThreadUsingThread {
    public static void main(String[] args) throws InterruptedException {

        ByRunnable jobOfByRunnable = new ByRunnable(); // Object of task which want to be executed.
        ByExtends extend = new ByExtends("ByExtends-Thread");

        Thread runnable =new Thread(jobOfByRunnable,"ByRunnable - Thread"); // thread creation of the job

        runnable.start();
        System.out.println(runnable.getName() + " started");
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        extend.start();
        System.out.println(extend.getName() + " started");

//        runnable.interrupt(); // This interrupts the Sleep state of Hi thread
        runnable.join(); // Main thread is waiting for 'runnable' thread to finish its execution
        extend.join(); // Main thread is waiting for 'extend' thread to finish its execution

        System.out.println("Main waiting for all tasks to complete");
    }
}
