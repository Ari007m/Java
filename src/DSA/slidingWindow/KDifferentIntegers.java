package DSA.slidingWindow;

public class KDifferentIntegers {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,4};
        int k = 3;
        System.out.println(subarraysWithKDistinct(nums, k));
    }

    static int subarraysWithKDistinct(int[] nums, int k){
        if(nums.length < k) return  0;
        return atmost(nums, k) - atmost(nums, k - 1);
    }

    /*
     * Can also use Hash Map
     * The constraint is 1 <= nums[i], k <= nums.length
     * So here freq array is used instead of HashMap
     * Otherwise HashMap is better & optimal option
     */
    static int atmost(int[] nums, int k){
        int n = nums.length;
        int got = 0;
        int res = 0;
        int[] freq = new int[n+1];

        for(int i = 0, j = 0; i < n; i++){

            if(freq[nums[i]]++ == 0) got++;

            while(got > k){
                freq[nums[j]]--;
                if(freq[nums[j]] == 0) got--;
                j++;
            }

            res += i - j + 1;
        }

        return res;
    }
}
