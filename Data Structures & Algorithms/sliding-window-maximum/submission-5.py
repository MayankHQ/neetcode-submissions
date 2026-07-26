class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        res = []
        n = len(nums)

        for i in range(n-k+1):
            maxi = -1_000_000_000
            for j in range(i, i+k):
                maxi = max(maxi, nums[j])
            res.append(maxi)
        
        return res
