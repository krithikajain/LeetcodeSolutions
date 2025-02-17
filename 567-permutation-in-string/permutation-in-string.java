class Solution {
    public boolean checkInclusion(String s1, String s2) {

        //initialize the frequency array for s1 and s2
        int[] s1freq = new int[26];
        int[] s2freq = new int[26];

        //Store the freq of s1 in array
        for(char c: s1.toCharArray()){
            s1freq[c-'a']++;
        }
        int left=0;
        //Sliding the window to count the freq of s2
        for(int right=0; right<s2.length(); right++){
            s2freq[s2.charAt(right)-'a']++;

            //if the window size exceeds then decrement left
            if (right - left + 1 > s1.length()) {
                s2freq[s2.charAt(left)-'a']--;
                left++;
            }
            if(matches(s1freq,s2freq)){
                return true;
            }
        }
            return false;
        }

        private boolean matches(int[] arr1, int[] arr2){
            for(int i=0; i<26; i++){
                if(arr1[i]!=arr2[i]){
                    return false;
                }
            }
                    return true;

    }
}