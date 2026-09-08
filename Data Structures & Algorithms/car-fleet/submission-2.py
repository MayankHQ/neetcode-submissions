class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        time = [0] * len(speed)
        cnt, slowtime = 0, 0.0
        for i in range(len(speed)):
            time[i] = (position[i], speed[i])
        time.sort(reverse = True)

        for x,v in time:
            t = (target-x)/v 
            if t > slowtime:
                cnt += 1
                slowtime = t
        return cnt
        