class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        //base case:
        if(n==0)    return 0;
        if(n==1)    return nums[0];
        
        //create a table to account all the max values for that position - O(n)
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i=2; i<n; i++){
        dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[n-1];
    }
}

//edge cases:
//n=0 --> 0
//n=1 --> nums[1];
//n=2 --> max(nums[0],nums[1]) + 
//n=3 --> we need to check the current house money and the position at i-2 