package thread_intro;

class Counter extends Thread{
    private int count;

    //The second Thread try to access this methode will be in the Blocked state until 1 st thread finishes
    public synchronized void incrementCount() {
        this.count = count + 1;
    }

    public synchronized int getCount() {
        return count;
    }
}

public class ThreadSynchronizeExample {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Thread t1 = new Thread (() -> {
            for(int i = 1;i<=1000;i++){
                c.incrementCount();
            }});
        Thread t2 = new Thread (() -> {
            for(int i = 1;i<=1000;i++){
                c.incrementCount();
            }});

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("The total Count is : "+c.getCount());

    }
}