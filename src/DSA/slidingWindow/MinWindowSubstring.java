package DSA.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindowUsingArray(s, t));
    }

    static String minWindowUsingHash(String s, String t){

        int sL = s.length();
        int tL = t.length();
        int got = 0;
        int min = Integer.MAX_VALUE;
        int minStart = 0;
        if(tL > sL) return "";

        Map<Character, Integer> tM = new HashMap<>();
        Map<Character, Integer> sM = new HashMap<>();

        for(char ch : t.toCharArray()){

            tM.put(ch, tM.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0, j = 0; j < sL; j++){

            char newCh = s.charAt(j);

            if(tM.containsKey(newCh)){
                sM.put(newCh, sM.getOrDefault(newCh, 0) + 1);
                if(sM.get(newCh) <= tM.get(newCh)) got++;
            }

            while(got == tL){
                if(j - i + 1 <= min){
                    min =  j - i + 1;
                    minStart = i;
                }

                char oldCh = s.charAt(i);
                if(tM.containsKey(oldCh)){
                    sM.put(oldCh, sM.getOrDefault(oldCh, 0) - 1);
                    if(sM.get(oldCh) < tM.get(oldCh)) {
                        got--;
                    }
                }
                i++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + min);
    }

    static String minWindowUsingArray(String s, String t) {
        if (t.length() > s.length()) return "";

        int[] need = new int[128];
        for (char ch : t.toCharArray()) need[ch]++;

        int missing = t.length();
        int left = 0, start = 0, minLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (need[ch] > 0) missing--;
            need[ch]--;

            while (missing == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char lc = s.charAt(left++);
                need[lc]++;
                if (need[lc] > 0) missing++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
