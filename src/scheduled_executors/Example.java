package scheduled_executors;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Example {
    public static void main(String[] args) {

        ScheduledExecutorService one = Executors.newScheduledThreadPool(5);

        Future<String> op = one.schedule(() ->{
            return "The task one ";
        },5, TimeUnit.SECONDS);

        try {
            System.out.println(op.get());
        }
        catch (Exception e){

        }
    }
}
