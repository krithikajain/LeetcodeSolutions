class Solution {
    public int maxArea(int[] height) {
        int l=0, r=height.length-1;
        int area=0;
        int res=0;
        while(l<r){
            area = (r-l)* Math.min(height[l],height[r]);
            res = Math.max(res, area);
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return res;
    }
}