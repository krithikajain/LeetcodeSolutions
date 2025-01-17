class Solution {
    public boolean isPalindrome(String s) {
        String st = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();

        int i=0, j=st.length()-1;
        while(i<j){
            if(st.charAt(i)!=st.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}