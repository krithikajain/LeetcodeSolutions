class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26]; //an array to count the freq of letters
        for(char c: magazine.toCharArray()){
            letters[c - 'a']++;
        }
        for(char c: ransomNote.toCharArray()){
            if(letters[c - 'a'] == 0)   return false;
            letters[c - 'a']--;
        }
        return true;
    }
}

//clarifications
//are both strings in lower case? yes
//is ransom<magazine? yes because all letters of ransom must occur in magazine
