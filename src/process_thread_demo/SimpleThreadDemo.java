package process_thread_demo;

public class SimpleThreadDemo {

    static class SimpleWorker implements Runnable {

        private String name;

        SimpleWorker(String name){
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + " Started running inside Process");
            for (int i =0 ; i<=3; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("->"+name+" Finished");
        }
    }

    public static void main(String[] args) throws InterruptedException{
        System.out.println("-- JVM Process started --");

        String mainThreadName = Thread.currentThread().getName();
        System.out.println(mainThreadName + " is current Thread");

        SimpleWorker worker = new SimpleWorker("worker1");
        Thread task1 = new Thread(worker);

        System.out.println(mainThreadName +" thread starting the worker thread");
        task1.start();

        System.out.println("Main thread doing it's work");
        Thread.sleep(500);

        System.out.println("The main thread waits for the task to complete");
        task1.join();

        System.out.println("All threads are done it's work");
        System.out.println("-- JVM Process terminated -- ");
    }
}
