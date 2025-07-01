class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //create a map
    Map<String, List<String>> anagrams = new HashMap<>();
        //loop through the array of strings
        for(String str:strs){
            //sort the strs[i], since strings are immutable i will convert them into mutable objects
            char[] ana = str.toCharArray();
            //sort the array
            Arrays.sort(ana); //["a","b","t"] -> convert back to string object
            String sorted = new String(ana);
            //check if it does not contain in the map
            if(!anagrams.containsKey(sorted)){
                //then create a key sorted and add a new list
                anagrams.put(sorted, new ArrayList<>());
            }
            //if contains then just get the key and add the value
            anagrams.get(sorted).add(str);
        }
        //return type is list of lists
        return new ArrayList<>(anagrams.values());
       
        
    }
}


//clarifications:
//empty string? -> return an empty string list
//['s']=[['s']]
//equal length ["aa","abc"]? not necessarily
//permutation of char, but contain same char
//["bat","tab"] -> sort -> abt - unique to others but same to them

