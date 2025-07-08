class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2]; //stores res in array since the return type is array
        for(int i=0; i<nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                res[0] = map.get(diff);
                res[1] = i;
            }
            map.put(nums[i],i);
        }
        return res;
    }
}

//clarifications
//one solution always exists 
//does it contain negative numbers? yes -- [2,-3,4] target=1 o/p [0,1]
//does it contain duplicates? yes
//check: arr[i]>target --> skip
//brute force: use two loops to find every combination to get target - O(n^2)
//optimal solution: using hashmaps<value,index> O(n) - and O(1)lookup

//1. while (i<n.length)
//2. take the diff and check contains key -- true return add[get.diff,i]
//3. else put in map[a[i],i]