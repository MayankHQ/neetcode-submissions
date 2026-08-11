class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1: return nums[0]
        if n == 2: return max(nums[0], nums[1])

        dp = [0] * n
        
        dp[0], dp[1] = nums[0], max(nums[0], nums[1])

        for idx in range(2, n):
            dp[idx] = max(nums[idx] + dp[idx-2], dp[idx-1])
        
        return dp[n-1]