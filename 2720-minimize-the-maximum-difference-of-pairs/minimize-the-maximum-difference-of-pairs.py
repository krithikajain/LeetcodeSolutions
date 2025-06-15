class Solution:
    def minimizeMax(self, nums: List[int], p: int) -> int:
        nums.sort()
        
        def canFormPairs(max_diff):
            i=0
            count=0
            while i<len(nums)-1:
                if nums[i+1] - nums[i] <= max_diff:
                    count+=1
                    i+=2
                else:
                    i+=1
            return count >= p

        low=0
        high=nums[-1]-nums[0]

        while low<high:
            mid=(low+high)//2
            if canFormPairs(mid):
                high=mid
            else:
                low=mid+1
            
        return low