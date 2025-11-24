class Solution:
    def isPalindrome(self, s: str) -> bool:
        # initialize two pointers
        left, right = 0, len(s) - 1

        #run the loop for pointers
        while left < right:
            #skip non-alphanumeric
            while left < right and not s[left].isalnum():
                left += 1
            while left < right and not s[right].isalnum():
                right -= 1
            
            #compare under same case
            if s[left].lower() != s[right].lower():
                return False
            
            left += 1
            right -= 1
        
        return True