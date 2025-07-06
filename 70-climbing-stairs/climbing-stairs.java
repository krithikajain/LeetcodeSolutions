class Solution {
    public int climbStairs(int n) {
        if(n<=1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2; i<=n; i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
//we knpw that
//n=0 no steps already at the top -- 1
//n=1 take 1 to top -- 1
//n=2 take 1+1 or 2 
//n=3 take 1+1+1 or 2+1 or 1+2
