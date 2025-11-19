from typing import List
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n=len(temperatures)
        ans = [0] * n
        stack = []

        #run a loop through the temp 
        for i, temp in enumerate(temperatures):
            #run a loop to compare the current temp and TOS (high temp)
            while stack and temp > temperatures[stack[-1]]:
                # current temp is greater
                prev_idx = stack.pop()
                ans[prev_idx] = i - prev_idx
            #current temp is smaller, push to the stack
            stack.append(i)
        
        return ans

