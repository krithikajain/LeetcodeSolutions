class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int top=0;
        int bot=m-1;
        int row=-1;
        while(top<=bot){
            int mid=(top+bot)/2;
            if(target>matrix[mid][n-1]){
                top = mid+1;
            } else if(target<matrix[mid][0]){
                bot = mid-1;
            } else {
                row=mid;
                break;
            }
        }
        if(row==-1){
            return false;
        }
        int low=0;
        int high = n-1;
        while(low<=high){
            int mr=(low+high)/2;
            if(target>matrix[row][mr]){
                low=mr+1;
            } else if(target<matrix[row][mr]){
                high=mr-1;
            } else {
                return true;
            }
        }
        return false;
    }
}