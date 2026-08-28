package DSA.LogicalProgram;

import java.util.Arrays;

public class RunningSum {
    static void main() {
        int[] arr = {1, 2, 1, 4, 5};
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i-1] + arr[i];
        }

        System.out.println(Arrays.toString(arr));
    }
}
