class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        pairs = {')': '(', ']': '[', '}': '{'}
    
    #every char in the string
        for ch in s:
            if ch in pairs.values(): #opening braces
                stack.append(ch)
            else:                   #closing braces
                if not stack or stack[-1] != pairs[ch]: #check empty stack or TOP != coressponding closing braces
                    return False
                stack.pop()

        return not stack #returns true since stck becomes empty

        

    
