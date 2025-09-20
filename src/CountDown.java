import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class CountDown {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.print("Enter the count to be Execuit:" );


        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {

            int count = s.nextInt();

            @Override
            public void run() {
                System.out.println(count);
                count--;
                if(count < 0){
                    System.out.println("That's it");
                    timer.cancel();
                }

            }
        };

        timer.scheduleAtFixedRate(timerTask,0,1000);
    }

}
