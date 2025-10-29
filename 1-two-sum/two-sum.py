class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # create a set
        seen = {} # num:idx
        # run a loop through nums
        for i, num in enumerate(nums):
            complement = target - num
            #check if complement found in seen
            if complement in seen:
                return [seen[complement], i]
            # add the num if not in seen
            seen[num] = i
