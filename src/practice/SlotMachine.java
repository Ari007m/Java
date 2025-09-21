package practice;

import java.util.Random;
import java.util.Scanner;

public class SlotMachine {
    public static void main(String[] args){
        /*
        Java slot machine program

        variable
        welcome message
        play bal>0
        enter bet amount
              verify bet > 0
              verify bet < bal
         spin
         print row
         payout
         ask to play again
         end note
         */

        Scanner s = new Scanner(System.in);
        double bal = 100;
        double bet ;
        double won ;
        String[] row ;
        String play ;
        System.out.println("WELCOME TO JAVA SLOT MACHINE");
        System.out.println("Symbols: ⭐ ❤️ 🥳 👻 🤡  ");

        while(bal > 0){
            System.out.println("Your balance: ₹"+bal);
            System.out.print("place your bet: ₹");
            bet = s.nextDouble();
            s.nextLine();
            if(bet <= 0 || bet > bal){
                System.out.println("INSUFFICIENT MONEY");
                continue;
            } else {
                bal-=bet;
            }
            System.out.println("Spinning ........");
            row = spin();
            printRow(row);
            won = payOut(row,bet);
            if(won > 0){
                System.out.println("You won: ₹"+won);
                bal += won;
            }
            else {
                System.out.println("Sorry you lost");
            }
            System.out.print("Do you want to play again(Y/N): ");
            play =s.next().toUpperCase();
            if(!play.equals("Y")){
                break;
            }
        }
        System.out.println("Game over !!! Your final balance: ₹"+bal);
        s.close();

    }
    static String[] spin(){

        String[] symbol = {"⭐","❤️","🥳","👻","🤡"};
        String[] row = new String[3];
        Random r = new Random();

        for(int i= 0; i<3 ; i++){
            row[i] = symbol[r.nextInt(symbol.length)];
        }

        return row;

    }
    static void printRow(String[] row){
        System.out.println(" "+String.join(" | ",row));
    }
    static double payOut(String[] row,double bet){
        if(row[0].equals(row[1]) && row[1].equals(row[2])){
            return switch (row[0]){
                case "⭐" -> bet*20;
                case "❤️" -> bet*10;
                case "🥳" -> bet*7;
                case "👻" -> bet*5;
                case "🤡" -> bet*2;
                default -> 0;

            };

        }
        else if(row[0].equals(row[1]) || row[1].equals(row[2])){
            return switch (row[1]){
                case "⭐" -> bet*10;
                case "❤️" -> bet*7;
                case "🥳" -> bet*5;
                case "👻" -> bet*2;
                case "🤡" -> bet*1;
                default -> 0;

            };

        }

        return 0;

    }


}
