class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        n = len(intervals)
        res = []
        i = 0

        #Add all intervals that come strictly BEFORE newInterval
        while i < n and intervals[i][1] < newInterval[0]:
            res.append(intervals[i])
            i += 1
        
        #Merge all OVERLAPPING intervals with newInterval
        while i < n and intervals[i][0] <= newInterval[1]:
            newInterval = [
                min(intervals[i][0], newInterval[0]),
                max(intervals[i][1], newInterval[1])
            ]
            i += 1
        
        #Add the fully merged newInterval
        res.append(newInterval)

        #Add all remaining intervals that come strictly AFTER newInterval
        # while i < n:
        #     res.append(intervals[i])
        #     i += 1
        
        res.extend(intervals[i:])

        return res