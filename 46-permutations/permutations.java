public class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
    res = new ArrayList<>();
    backtracking(nums, res, new ArrayList<>());
    return res;
    }

    private void backtracking(int[] nums, List<List<Integer>> result, List<Integer> tempList){
        //base condition
        if(tempList.size() == nums.length){ //all the positions are filled
            result.add(new ArrayList<>(tempList));
            return;
        }
        for(int num: nums){
            //there shouldn't a num repeated at the same postion we could skip it
            if(tempList.contains(num))  continue;

            tempList.add(num); //add it to the list

            backtracking(nums, result, tempList); //call for the next positions and return 
            
            tempList.remove(tempList.size()-1); //remove the elements to go back to the previous state
        }
    }
}

//Clarifications
//contains all distinct nums
//can contain neg
//ranges from 1 - 6
//n=1 [1] -> [[1]]
//n=2 (0,1) -> [[0,1], [1,0]]
//n=3 (1,2,3) -> [[1,2,3], [1,3,2],
//                 [2,1,3], [2,3,1],
//                 [3,1,2], [3,2,1]]
//each position there is no repition of a number
// _ _ _ -> 3 X 2 X 1 = 6 -> n! 