class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        //1. create 2 hashsets to add all the numbers
        Set<Integer> set1 = new HashSet<>();
        for (int x: nums1){
            set1.add(x);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int x: nums2){
            set2.add(x);
        }
        //Compute the diff i.e if num from set1 not present in set2 then add to the list
        List<Integer> list1 = new ArrayList<>();
        for(int x: set1){
            if(!set2.contains(x)){
                list1.add(x);
            }
        }

        List<Integer> list2 = new ArrayList<>();
        for(int x: set2){
            if(!set1.contains(x)){
                list2.add(x);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(list1);
        result.add(list2);
        return result;
    }
}

//clarifications
//duplicates exist - should be ignored in the o/p and considered as unique value
//does the order matter?
//no values found then return an empty set

//brute force
//check every value in num1 against num2, if appears add it to answer[0] and vice versa
//nested loops - O(nxn)

//optimal way could be to use hashsets

