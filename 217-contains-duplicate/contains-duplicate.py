class Solution(object):
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        # we know that: nums is distinct 
        # does it have neg integers? is nums.length=0?
        # brute force - 2 for loops - sort check for i and i+1
        hash = set()
        for num in nums:
            if num in hash:
                return True
            hash.add(num)

        return False
