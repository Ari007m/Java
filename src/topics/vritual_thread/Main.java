package topics.vritual_thread;

public class Main {
    static void main() throws InterruptedException {

        Thread.Builder thread = Thread.ofVirtual()
                .name("Demo thread");

        Thread t1 = thread.start(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Finished");
            }
            catch (InterruptedException e){
                System.out.println("Interrupted");
            }
        });
        Thread t2 = thread.start(() -> System.out.println("Can't wait"));

        System.out.println("Main out");
        System.out.println( t1.isDaemon());

        t1.sleep(2000);

    }
}
