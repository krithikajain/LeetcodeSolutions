class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        left, right = 0, len(numbers) - 1

        #loop through 2 pointers
        while left < right:
            s = numbers[left] + numbers[right]

            if s == target:
                return [left + 1, right + 1] #convert to 1-indexed
            elif s > target:
                right -= 1
            else:
                left += 1