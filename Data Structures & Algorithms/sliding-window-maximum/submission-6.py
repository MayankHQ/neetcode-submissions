class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        res = []
        dq = deque()
        for i in range(n):
            while (dq and nums[dq[-1]] < nums[i]):
                dq.pop()
            dq.append(i)

            if dq[0] <= i-k:
                dq.popleft()
            
            if i >= k-1:
                res.append(nums[dq[0]])
        
        return res


        