class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        end = max(piles, default = 0)
        start = 1
        res = end
        while start <= end:
            mid = (start + end)//2

            totalTime = 0
            
            for p in piles:
                totalTime += (p + mid - 1)//mid
            if totalTime <= h:
                res = mid
                end = mid - 1
            else:
                start = mid + 1
        return res