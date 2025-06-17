class Solution {
    public boolean canPartition(int[] nums) {
        //edge cases:
        //[] empty - cannot partition; return false
        //[100] - single cannot partition; return false
        //[1,2,5,3] = sum = 11 = {5,6} odd; cannot create two equal partitions
        //[1,2,5,2] = sum = 10 {5,5} even;  creates two equal partitions
        //[1,1,1,1,1,1] = multiple equal subsets

        int total = Arrays.stream(nums).sum();
        //if the total sum is odd it cannot create equal partitions
        if(total%2 != 0){
            return false;
        }

        int sum=total/2;
        int n=nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        
        //base case: sum=0 then i assume my arr is empty 
        for(int i=0; i<=n; i++){
            dp[i][0]=true;
        }
        //fill the table
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                
               //either exclude or include
               if(nums[i-1] <= j){
                dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
               } else{
                //exclude
               dp[i][j] = dp[i-1][j];
               }
            }
        }
        return dp[n][sum];
    }   
}