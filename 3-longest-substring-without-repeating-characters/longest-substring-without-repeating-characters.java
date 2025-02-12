class Solution {
    public int lengthOfLongestSubstring(String s) {
       HashSet<Character> set = new HashSet<>();
       char[] ch = s.toCharArray();
       int left=0, right=0, max=0;
       while(right<ch.length){
        if(!set.contains(ch[right])){
            set.add(ch[right]);
            max = Math.max(max, right-left+1);
            right++;
        }else{
            set.remove(ch[left]);
            left++;
        }
       }
       return max;
    }
}