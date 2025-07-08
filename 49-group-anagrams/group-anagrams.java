class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();
        for(String str: strs){
            char[] anagram = str.toCharArray();
            Arrays.sort(anagram);
            String sorted = new String(anagram);
            if(!group.containsKey(sorted)){
                group.put(sorted, new ArrayList<>());
            }
            group.get(sorted).add(str);
        }
        return new ArrayList<>(group.values());
    }
}


//clarifications:
//empty string? -> return an empty string list
//['s']=[['s']]
//equal length ["aa","abc"]? not necessarily
//permutation of char, but contain same char
//["bat","tab"] -> sort -> abt - unique to others but same to them

