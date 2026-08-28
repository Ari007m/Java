package DSA.LogicalProgram;

import java.awt.event.MouseAdapter;

public class MaxProfit {

    static void main() {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, count = 0;

        for (int i : prices){
            if(min > i){
                max = i;
                min = i;
            }
            max = Math.max(max, i);
            count = Math.max(count, max - min);
        }
        return count;
    }
}
