class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        // Copy nums[0..n-2] into arr1
        int[] arr1 = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            arr1[i] = nums[i];
        }

        // Copy nums[1..n-1] into arr2
        int[] arr2 = new int[n - 1];
        for (int i = 1; i < n; i++) {
            arr2[i - 1] = nums[i];
        }

        return Math.max(houses(arr1), houses(arr2));
    }

    public int houses(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[n - 1];
    }
}
