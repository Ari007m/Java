package practice;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Audio {
    public static void main(String[] args) {

        String path = "C:\\Users\\ariha\\Downloads\\MATUSHKA PHONK [ MATUSHKA ZEMLYA BRAZILIAN FUNK ] (promodj.com).wav";
        File file = new File(path);

        try(Scanner s =new Scanner(System.in);AudioInputStream a = AudioSystem.getAudioInputStream(file)){
            Clip c = AudioSystem.getClip();
            c.open(a);
            System.out.println("File opened");


            String ip ="";
            while (!ip.equals("Q")){
                System.out.println("P = Play");
                System.out.println("S = Stop");
                System.out.println("R = Reset");
                System.out.println("Q = Quit");
                System.out.print("Enter your Choice: ");

                ip = s.next().toUpperCase();

                switch (ip){
                    case "P" -> c.start();
                    case "S" -> c.stop();
                    case "R" -> c.setMicrosecondPosition(0);
                    case "Q" -> c.close();
                    default -> System.out.println("Invalid Choice");
                }

            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");

        }
        catch (UnsupportedAudioFileException e){
            System.out.println("Audio type not supported");
        }
        catch (LineUnavailableException e){
            System.out.println("Unable to access");
        }
        catch (IOException e){
            System.out.println("Something went wrong");
        }
        finally {
            System.out.println("Done");
        }
    }

}

