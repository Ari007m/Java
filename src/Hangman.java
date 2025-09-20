import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {

    String path = "text.txt";
      ArrayList<String> words = new ArrayList<>();

      try(BufferedReader reader = new BufferedReader(new FileReader(path))){
          String line ;
          while((line = reader.readLine()) != null){
              words.add(line.trim().toLowerCase());

          }

      }
      catch (FileNotFoundException e){
          System.out.println("File not Found");
      }
      catch (IOException e){
          System.out.println("Something went wrong");
      }
      Random random =new Random();

      String word = words.get(random.nextInt(words.size()));

        Scanner s = new Scanner(System.in);
        ArrayList<Character> wordstate = new ArrayList<>();
        int wrong = 0 ;

        for(int i =0 ; i < word.length() ; i++){
            wordstate.add('_');

        }

        System.out.println("JAVA HANGMAN GAME");

        while(wrong < 6){

            System.out.println(getHangman(wrong));

            System.out.println("Word: ");

            for(char c : wordstate){
                System.out.print(c+" ");
            }
            System.out.println();

            System.out.print("Guess a letter: ");
            char g = s.next().toLowerCase().charAt(0);

            if (word.indexOf(g) >= 0){
                System.out.println("Correct guess");

                for(int i =0 ;i < word.length();i++){
                    if(word.charAt(i) == g){
                        wordstate.set(i,g);
                    }
                }
                if (!wordstate.contains('_')){
                    System.out.println(getHangman(wrong));
                    System.out.println("You Win!");
                    System.out.println("The word is: "+word);
                    break;
                }
            }
            else {
                System.out.println("wrong guess!");
                wrong++;
            }
        }
        if(wrong >= 6){
            System.out.println(getHangman(wrong));
            System.out.println("You Lost!");
            System.out.println("The word is: "+word);
        }

        s.close();

    }
    static String getHangman(int wrong){
        return switch (wrong){
            case 0 -> """
                    
       
                    """;
            case 1 -> """
                       O
                    
                    
                    """;
            case 2 -> """
                       O
                       |
                    
                    """;
            case 3 -> """
                       O
                      /|
                    
                    """;
            case 4 -> """
                       O
                      /|\\
                    
                    """;
            case 5 -> """
                       O
                      /|\\
                      /
                    """;
            case 6 -> """
                       O
                      /|\\
                      / \\
                    """;
            default -> "";
        };
    }
}
