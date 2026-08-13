"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        map = defaultdict(int)
        for i in intervals:
            map[i.start] += 1
            map[i.end] -= 1
        
        overlap = maxoverlaps = 0

        for i in sorted(map.keys()):
            overlap += map[i]
            maxoverlaps = max(maxoverlaps, overlap)
        
        return maxoverlaps