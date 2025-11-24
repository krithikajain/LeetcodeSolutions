class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        #if my list is empty
        if not nums:
            return 0

        #create a set of nums
        num_set = set(nums)
        longest = 0

        #loop through every num in the set
        for n in num_set:
            #check at n-1 since we start the seq from beginning
            if (n-1) not in num_set:
                length = 1
                cur = n #pointer to the current start

                #look for consecutive no
                while (cur+1) in num_set:
                    cur += 1
                    length += 1
                
                #find the max
                longest = max(longest, length)
        
        return longest
                