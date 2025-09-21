package practice;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

public class AlarmClock implements Runnable {

    private final LocalTime alarmTime;
    private final String path;
    private final Scanner s;

    AlarmClock(LocalTime alarmTime , String path, Scanner s){
        this.alarmTime = alarmTime;
        this.path = path;
        this.s = s;
    }

    @Override
    public void run(){

        while (LocalTime.now().isBefore(alarmTime)){
            try {
                Thread.sleep(1000);

                LocalTime now = LocalTime.now();
                System.out.println(now);

                System.out.printf("\r%02d:%02d:%02d",
                        now.getHour(),
                        now.getMinute(),
                        now.getSecond());
            }
            catch (InterruptedException e){
                System.out.println("Thread was Interrupted");
            }
        }

        System.out.println("\n*Alarm Noise*");
        play(path);

    }

    private void play(String path) {
        File audio =new File(path);

        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(audio)){

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            System.out.println("Press *Enter* to stop");
            s.nextLine();
            clip.stop();
            s.close();
        }
        catch (UnsupportedAudioFileException e){
            System.out.println("Unsupported format");
        }
        catch (LineUnavailableException e){
            System.out.println("Audio is unavailable");
        }
        catch (IOException e){
            System.out.println("Something Went Wrong");
        }
    }

}
