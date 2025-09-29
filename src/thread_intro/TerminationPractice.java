package thread_intro;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TerminationPractice {

    /**
     * The shutdown() function is used for closing the thread after execution or after execution it tells to terminate the thread.
     * The awaitTermination() is the optional function used to get the boolean value of thread running status (true if the thread terminated, false if it's not).
     * The shutdownNow() is the function that immediately terminates the thread even though it's running, after it may return the waiting task in queue.
     */
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);

        service.submit(() -> {
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("The task completed");
        });

        service.shutdown();

        try {
            boolean isTerminate = service.awaitTermination(2, TimeUnit.SECONDS);
            System.out.println("The isTerminated : "+isTerminate);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("The Main thread is completed");
    }
}
