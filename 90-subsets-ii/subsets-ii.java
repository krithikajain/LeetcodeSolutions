class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       Arrays.sort(nums);
       List<List<Integer>> result = new ArrayList<>();
       backtracking(0, nums, new ArrayList<>(), result);
       return result;
    }
    private void backtracking(int i, int[] nums, List<Integer> subset, List<List<Integer>> result){
        if(i == nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        //include the number
        subset.add(nums[i]);
        backtracking(i+1, nums, subset, result);
        subset.remove(subset.size()-1);

        //checks for duplicate
        while(i+1<nums.length && nums[i]==nums[i+1]){
            i=i+1;
        }

        //exclude
        backtracking(i+1, nums, subset, result);
    }
}


//edge cases; 
//[1] -> [],[1]
//negative integers stay as is
//[1,1,1] all duplicates -> [],[1],[1,1],[1,1,1]


//sort - nlogn
//tc - 2^n and skip duplicates