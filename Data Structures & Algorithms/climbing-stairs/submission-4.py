class Solution:
    def climbStairs(self, n: int) -> int:
        memo = {0:1, 1:1}
        def helper(x):
            if x in memo:
                return memo[x]
            else:
                memo[x] = helper(x-1) + helper(x-2)
                return memo[x]
        return helper(n)
