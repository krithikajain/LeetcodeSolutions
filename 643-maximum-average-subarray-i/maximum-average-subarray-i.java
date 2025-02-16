class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum=0;
        double max = Double.MIN_VALUE;
        for(int i=0; i<k; i++){
            sum+=nums[i];
        }
        max=sum/k;
        for(int i=k; i<nums.length; i++){
            sum = sum + nums[i] - nums[i-k];
            max = Math.max(max, sum/k);
        }
        return max;
    }
}