package DSA.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountNiceSubarrays {
    public static void main(String[] args) {
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        System.out.println(numberOfSubarrays(nums, k));
    }

    static int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    static int atMost(int[] nums, int k) {
        int left = 0;
        int oddCount = 0;
        int count = 0;
        for(int right = 0; right < nums.length; right++) {
            if((nums[right] & 1) == 1) {
                oddCount++;
            }
            while(oddCount > k) {
                if((nums[left] & 1) == 1) {
                    oddCount--;
                }
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}
