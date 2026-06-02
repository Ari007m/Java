package DSA.slidingWindow;

public class CharacterReplacement {
    public static void main(String[] args) {

        String s = "AABABBA";
        int k = 1;

        System.out.println(characterReplacement(s, k));
    }

    static int characterReplacement(String s, int k){

        int n = s.length();
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int ans = 0;
        for(int right = 0; right < n; right++){

            char ch = s.charAt(right);
            freq[ch - 'A']++;
            maxFreq = Math.max(maxFreq, freq[ch-'A']);

            while((right - left + 1) - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            ans = Math.max(ans, right - left +1);
        }
        return ans;
    }

}
