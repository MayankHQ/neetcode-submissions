class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        pair =  list(zip(position, speed))
        pair.sort(reverse = True)
        cnt, slowtime = 0, 0.0

        for x, v in pair:
            time = (target - x)/v
            if time > slowtime:
                cnt += 1
                slowtime = time
        return cnt