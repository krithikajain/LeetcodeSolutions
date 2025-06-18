class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //what we know:
        //distinct [2,3,6,7] t=7 order doesn't matter
        //[2,3,2]=[2,2,3]=[3,2,2] => 1 combination
        //return is list of list of type int
        //edge cases:
        //target=0 -> {} and combination.length>=1
        //target is neg?

        //brute force - huge resursion 
result = new ArrayList<List<Integer>> ();        
List<Integer> subset = new ArrayList<>();
        backtrack(candidates, target, subset, 0);
        return result;
    }

    private void backtrack(int[] candidates, int target,List<Integer> subset, int i)
    {
        if(target==0){
            result.add(new ArrayList(subset));
            return;
        }
        if(target<0 || i>=candidates.length){
            return;
        }
        subset.add(candidates[i]);
        backtrack(candidates, target-candidates[i], subset, i);
        subset.remove(subset.size()-1);
        backtrack(candidates, target, subset, i+1);
    }
}