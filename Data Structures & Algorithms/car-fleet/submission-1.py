class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        cars = sorted(zip(position, speed), reverse = True)
        slow_time, fleet = 0.0, 0
        #stack = []
        for pos, spd in cars:
            time = (target - pos)/spd
            if time > slow_time:
                fleet += 1
                slow_time = time
            # if not stack or time > stack[-1]:
            #     stack.append(time)
        return fleet

            