package DSA.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitBasket {
    public static void main(String[] args) {
        int[] fruits = {1,0,1,4,1,4,1,2,3};
        System.out.println(totalFruit(fruits));
    }

    static int totalFruit(int[] fruits){

        int i = 0;
        int prev = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int max=0;

        for(int j = 0; j < fruits.length; j++){

            int fruit = fruits[j];
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);

            while(map.size() > 2) {

                int left = fruits[i];
                int freq = map.get(left)-1;
                if(freq == 0) map.remove(left);
                else map.put(left, freq);

//                map.put(fruits[i], map.getOrDefault(fruits[i], 0) - 1);
//                if (map.get(fruits[i]) == 0) map.remove(fruits[i]);
                i++;

            }
            max = Math.max(max, j - i +1);
        }
        return max;
    }
}
