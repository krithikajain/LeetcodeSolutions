class Solution {
    public void sortColors(int[] nums) {
        sortArray(nums,nums.length);
    }  
        public static void sortArray(int[] arr, int n){
            if (n<=1) return;

            int last = arr[n-1];
            sortArray(arr, n-1);
            insert(arr, n-1, last);
        }
        public static void insert(int[] arr, int n, int val){
            if(n==0 || arr[n-1]<= val){
                arr[n]=val;
                return;
            }
            int temp = arr[n-1];
            arr[n]=temp;
            insert(arr,n-1,val);
        }
}