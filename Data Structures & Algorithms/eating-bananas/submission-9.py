class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        maxi = max(piles)
        s, e = 1, maxi
        res = maxi

        while s <= e:
            speed = (s+e)//2
            time = 0
            for pile in piles:
                time += (pile + speed - 1)//speed
            if time <= h:
                res = speed
                e = speed - 1
            else:
                s = speed + 1
        return res