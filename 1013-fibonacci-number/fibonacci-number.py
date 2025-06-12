class Solution:
    def fib(self, n: int) -> int:
        memo={0:0,1:1}

        # if n==0:
        #     return 0
        # if n==1:
        #     return 1
        
        # return self.fib(n-1)+self.fib(n-2)
        def f(x):
            if x in memo:
                return memo[x]
            else:
                memo[x]=f(x-1)+f(x-2)
                return memo[x]
            
        return f(n)
            