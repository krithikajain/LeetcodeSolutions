class Solution {
    public int takeCharacters(String s, int k) {
        int[] count = new int[3];
        int n = s.length();
        
        //total occurences
        for(char c:s.toCharArray()){
            count[c-'a']++;
        }

        //check if we have atleast k values of each char
        if(count[0]<k || count[1]<k || count[2]<k){
            return -1;
        }
        int maxWindow = 0; //maximum window size
        int left=0;
        int[] window = new int[3]; //tracking occurences in current window
        
        //sliding window; finding the longest window that leaves k char outside
        for(int right=0; right<n; right++){
            window[s.charAt(right) - 'a']++;//expand the window

            //shrink the window if we take too many characters
            while(left<=right &&
            count[0]-window[0]<k || count[1]-window[1]<k || count[2]-window[2]<k){
                window[s.charAt(left)-'a']--;
                left++;
            }
            maxWindow = Math.max(maxWindow, right-left+1);

        }
        return n-maxWindow;
    }
}