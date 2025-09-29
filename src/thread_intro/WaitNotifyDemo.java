package thread_intro;

class Shared {
    private boolean available = false;

    public synchronized void produce(){
        while (available) {
            try {
                wait();  // release lock and wait
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
            wait();  // release lock and wait
        }
        System.out.println("Consumed an item");
        available = false;
        notify();   // wake up producer
    }
}

public class WaitNotifyDemo {
    public static void main(String[] args) {
        Shared s = new Shared();

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
