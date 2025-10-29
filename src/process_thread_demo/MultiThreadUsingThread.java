package process_thread_demo;

class Hii implements Runnable{
// This Class implements runnable which has single method
    public void run() {
        for(int i=0;i<=30;i++){
            System.out.println("This is Hii");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Hello extends Thread{

    public void run() {
        for(int i=0;i<=20;i++){
            System.out.println("This is Hello");
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

        Hii jobOfHi = new Hii(); // Object of task which want to be executed.
        Hello hello = new Hello();

        Thread hi =new Thread(jobOfHi); // thread creation of the job

        hi.start();
        System.out.println("Hi started");
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        hello.start();
        System.out.println("Hello started");

        hi.join(); // Main thread is waiting for 'hi' thread to finish its execution
        hello.join(); // Main thread is waiting for 'hello' thread to finish its execution

        System.out.println("Main waiting for all tasks to complete");
    }
}
