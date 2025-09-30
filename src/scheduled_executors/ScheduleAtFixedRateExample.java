package scheduled_executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleAtFixedRateExample {
    public static void main(String[] args) {

        ScheduledExecutorService two = Executors.newScheduledThreadPool(4);

        two.scheduleAtFixedRate(() ->{
            System.out.println("Hello");
        },5,3, TimeUnit.SECONDS);
    }
}
