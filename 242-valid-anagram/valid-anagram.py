class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        
        #clarification; all lowercase; empty string?
        #edge case: s.length != t.length - false
        if len(s) != len(t):
            return False

        countS, countT = {},{}
        for i in range(len(s)):
            countS[s[i]] = countS.get(s[i],0) + 1
            countT[t[i]] = countT.get(t[i],0) + 1

        return countS == countT
