class Solution {
    public boolean containsDuplicate(int[] nums) {
        //1. create a hashset
        Set<Integer> dupes = new HashSet<>();
        //2. run a loop through each nums
        for(int num : nums){
            //3. check if the set contains the num 
            if(dupes.contains(num))
                return true; //duplicate exists
            dupes.add(num);  //otherwise add it to the set
        }
        return false; //duplicate found!
    }
}

//brute force - create two loops and compare values -- not ideal as the tc = O(nxn)
//Optimal way - hashset
