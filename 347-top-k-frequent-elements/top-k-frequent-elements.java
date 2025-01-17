class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // counting the freq
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num:nums){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }
        // convert into list 
        List<int[]> arr = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()){
            arr.add(new int[]{entry.getValue(),entry.getKey()});
        }
        //sort the arr in ascending order
        arr.sort((a,b)->a[0]-b[0]);

        //print the top k elements
        int[] result = new int[k];
        for(int i=0; i<k; i++){
            result[i]=arr.get(arr.size()-1-i)[1];
        }
        return result;
    }
}