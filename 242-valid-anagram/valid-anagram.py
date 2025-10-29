class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        #check if lengths are equal to proceed
        if len(s) != len(t):
            return False

        # initialise a dictionary
        count = {}
        #add char from s
        for char in s:
            count[char] = count.get(char,0) + 1
        #remove char from s looking into t
        for char in t:
            if char not in count:
                return False
            count[char] -= 1

            if count[char] < 0: return False
        
        return True