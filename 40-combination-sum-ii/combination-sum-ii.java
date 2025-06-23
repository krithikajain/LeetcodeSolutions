class Solution {
        List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), 0);
        return result;
    }
    private void backtrack(int[] candidates, int target, int total, List<Integer> cur, int i){
            if(total == target){
                result.add(new ArrayList<>(cur));
                return;
            }
            if(total>target || i>=candidates.length){
                return;
            }
            // include
                cur.add(candidates[i]);
                backtrack(candidates, target, total+candidates[i],cur, i+1);
                // exclude
                cur.remove(cur.size()-1);
                while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
                backtrack(candidates, target, total, cur , i+1);
            
    }
}