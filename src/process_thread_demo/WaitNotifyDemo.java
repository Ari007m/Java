package process_thread_demo;

/**
 Two threads are running parallel .
 Each thread notify() each others for wake it from the Wait() state.
 */
class Shared {
    private boolean available = false;

    //The Second thread which comes to access this method gets blocked until 1st thread releases lock
    public synchronized void produce(){
        while (available) {
            try {
                wait();  //  non-runnable state where a thread voluntarily gives up its execution rights
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Produced an item");
        available = true;
        notify();   // wake up one waiting thread
    }

    public synchronized void consume() throws InterruptedException {
        while (!available) {
            wait();
        }
        System.out.println("Consumed an item");
        available = false;
        notify();   // wake up producer -- if it is not called the producer will wait due to both using same object for lock, due to thread scheduling The producer goes wait stage it notifies that
    }
}

public class WaitNotifyDemo {
    public static void main(String[] args) {
        Shared s = new Shared(); // Same object for both threads for managing monitor lock, ensure only one thread runs at a time.

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 3; i++) s.produce();
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) s.consume();
            } catch (InterruptedException e) { }
        });

        producer.start();
        consumer.start();
    }
}
