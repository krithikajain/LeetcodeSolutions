class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        // Frequency map of characters in t
        Map<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray())
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);

        int required = tCount.size();
        int formed = 0;

        Map<Character, Integer> window = new HashMap<>();
        int l = 0, r = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (r < s.length()) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            // Only increase formed if c is needed and matched
            if (tCount.containsKey(c) && window.get(c).intValue() == tCount.get(c).intValue()) {
                formed++;
            }

            // Try shrinking the window when valid
            while (formed == required) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if (tCount.containsKey(leftChar) && window.get(leftChar) < tCount.get(leftChar)) {
                    formed--;
                }
                l++; // Shrink from the left
            }

            r++; // Expand to the right
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
