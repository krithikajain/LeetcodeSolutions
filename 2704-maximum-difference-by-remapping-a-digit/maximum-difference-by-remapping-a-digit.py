class Solution:
    def minMaxDifference(self, num: int) -> int:

        s = str(num)

        #convert to max value
        for d in s:
            if d!='9':
                max_str = s.replace(d,'9')
                break
            else:
                max_str = s

        #convert to min value
        min_str = s.replace(s[0],'0')

        return int(max_str)-int(min_str)