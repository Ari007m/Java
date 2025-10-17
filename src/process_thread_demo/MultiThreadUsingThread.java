package process_thread_demo;

class Hii implements Runnable{

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

        Hii jobOfHi = new Hii();
        Hello hello = new Hello();

        Thread hi =new Thread(jobOfHi);

        hi.start();
        System.out.println("Hi started");
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        hello.start();
        System.out.println("Hi started");

        hi.join();
        hello.join();

        System.out.println("Main waiting for all tasks to complete");
    }
}
