public class Examples {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3; // Window size

        int maxSum = maxSumKElements(arr, k);
        System.out.println("Maximum sum of " + k + " consecutive elements: " + maxSum);
    }

    public static int maxSumKElements(int[] arr, int k) {
        if (arr.length < k) return -1; // Invalid case

        int windowSum = 0;
        int maxSum ;

        // Compute sum of first 'k' elements
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        // Slide the window across the array
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k]; // Add new element, remove old element
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

}
