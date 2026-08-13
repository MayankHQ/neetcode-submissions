class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key = lambda x : x[1])

        prev_end = float('-inf')
        removals = 0

        for interval in intervals:
            if interval[0] >= prev_end:
                prev_end = interval[1]
            
            else:
                removals += 1
        
        return removals