package practice;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Alarm {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;

        String path ="src/practice/MATUSHKA PHONK.wav";

        while (alarmTime == null){
            try {
                System.out.print("Enter the Alarm Time (HH:MM:SS): ");
                String inputTime = s.nextLine();

                alarmTime = LocalTime.parse(inputTime,formatter);
                System.out.println("The Alarm set for "+ alarmTime);
            }
            catch (DateTimeParseException e) {
                System.out.println("Invalid format");

            }
        }

        AlarmClock alarmClock = new AlarmClock(alarmTime , path ,s);
        Thread alarmThread = new Thread(alarmClock);
        alarmThread.start();

    }
}
