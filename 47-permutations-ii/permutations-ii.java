class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        //sort since it contains duplicates
        Arrays.sort(nums);
        backtracking(nums, result, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }
    private void backtracking(int[] nums, List<List<Integer>> result, List<Integer> tempList, boolean[] used){
        //base case if it forms a permuted list and also check if it is a duplicate permute
        if(tempList.size() == nums.length && !result.contains(tempList)){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=0; i<nums.length; i++){
            //skip the element if it is already added
            if(used[i] == true) continue; 

            used[i] = true; //mark as used
            tempList.add(nums[i]); //add to the potential list

            backtracking(nums, result, tempList, used); //call for next positions (i.e go back and try another element)

            //go back to the previous state by undoing
            used[i] = false;
            tempList.remove(tempList.size()-1);

        }
    }
}

 //boolean array to keep track of the number used
