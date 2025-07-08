class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        //create a map
        Map<Integer, Integer> freqmap = new HashMap<>();
        for(int num:nums){
            freqmap.put(num,freqmap.getOrDefault(num,0)+1);
        }

        //create a bucket array whose index value is my freq
        List<Integer>[] bucket = new ArrayList[nums.length+1];
        //go through the map and add the values in the bucket
        for(int key: freqmap.keySet()){
            int freq = freqmap.get(key);
            if(bucket[freq] == null){
            bucket[freq] = new ArrayList<>(); //initializing the arraylist inside the bucket
        }
        bucket[freq].add(key);
        }

        //store the result in an array
        int[] result = new int[k];
        int index=0; //pointer in my result
        for(int i=bucket.length-1; i>=0 && index<k; i--){
            if(bucket[i]!=null){
                for(int num: bucket[i]){
                    result[index++] = num;
                    if(index == k)  break;
                }
            }
        }
            return result;

    }
}

//clarifications
//empty string --- x
//contains [1] --- [1]
//k range [1, length of nums] - [1,2,3,4] k=4=length of nums
//can have neg

//create a map<value, freq> and put the values
//append the values in the list, sort it and get the last k elements in the list --- O(nlogk)

//bucket sort
//create bucket array where the index would be my freq --- O(n)
//ex=[1,2,2,40] => 1,1  2,2  40,1 --> 1,{1,40} 2,{2}