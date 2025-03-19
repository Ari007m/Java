import java.util.*;

public class Main {
    public static void main(String[] args) {
        double w;
        int c;
        double nw;

        Scanner s = new Scanner(System.in);

        System.out.println("Weight conversion");
        System.out.println("1 : converts weight from lbs to kgs ");
        System.out.println("2 : converts weight from kgs to lbs ");
        System.out.println("Enter your choice: ");
        c = s.nextInt();

        if(c == 1){
            System.out.println("Enter weight in lbs: ");
            w = s.nextInt();
            nw = w * 0.453592;
            System.out.printf("The %.2f in lbs is equal to %.2f kgs",w,nw);

        }
        else{
            System.out.println("Enter weight in kgs: ");
            w = s.nextInt();
            nw = w / 0.453592;
            System.out.printf("The %f in kgs is equal to %f lbs",w,nw);

        }

    }
}