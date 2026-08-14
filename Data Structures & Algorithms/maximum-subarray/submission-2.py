class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        total, maxi = 0, float('-inf')
        for num in nums:
            total += num
            if maxi < total:
                maxi = total
            if total < 0:
                total = 0
        return maxi