class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26]; //holds 26 lowercase letters
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        //loop through the s and for that pos find first ocurance of one and break
        for(int i=0; i<s.length(); i++){
            if(freq[s.charAt(i) - 'a'] == 1) 
                return i;
        }
        return -1;
    }
}
//clarifications
//only lowercase? yes 
//freq prob could use hashmaps/ array
//since we use only lowercase we can stick to arrays