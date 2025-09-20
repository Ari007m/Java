import java.util.Random;
import java.util.Scanner;

public class Dice {
    /*
    Java dice roll program

    declare the variables
    get the no. of dice from user
    no. of dice >0
    roll the dice
    get the tot
    display ASCII of dice
     */

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int nod ;
        int tot = 0;

        System.out.print("Enter the no. of Dice : ");
        int n = s.nextInt();

        if(n > 0){
            for (int i =0 ; i < n; i++){
                int roll= r.nextInt(1,7);
                die(roll);
                System.out.println("The number you have got : "+roll);
                tot += roll;
            }
            System.out.println("The total you have got: "+ tot);

        }
        else {
            System.out.println("Enter the valid number");
        }
    }
    static void die(int roll){
        String die1 = """
                 -------
                |       |
                |   ●   |
                |       |
                 -------
                """;
        String die2 = """
                 -------
                | ●     |
                |       |
                |     ● |
                 -------
                """;
        String die3 = """
                 -------
                | ●     |
                |   ●   |
                |     ● |
                 -------
                """;
        String die4 = """
                 -------
                | ●   ● |
                |       |
                | ●   ● |
                 -------
                """;
        String die5 = """
                 -------
                | ●   ● |
                |   ●   |
                | ●   ● |
                 -------
                """;
        String die6 = """
                 -------
                | ●   ● |
                | ●   ● |
                | ●   ● |
                 -------
                """;

        switch (roll) {
            case 1 -> System.out.println(die1);
            case 2 -> System.out.println(die2);
            case 3 -> System.out.println(die3);
            case 4 -> System.out.println(die4);
            case 5 -> System.out.println(die5);
            case 6 -> System.out.println(die6);
            default -> System.out.println("INVALID ROLL");
        }
    }
}
