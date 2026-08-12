class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        res = []

        for i in range(len(intervals)):
            #if new = [1,2] and interval[i] = [3,5], add new to res and all remaining from intervals
            if newInterval[1] < intervals[i][0]:
                res.append(newInterval)
                return res + intervals[i:]

            #if interval[i] = [3,5] and new = [7,10], add interval array for now to res
            elif newInterval[0] > intervals[i][1]:
                res.append(intervals[i])

            #merge overlapping
            else:
                newInterval = [
                    min(intervals[i][0], newInterval[0]),
                    max(intervals[i][1], newInterval[1])
                ]
        res.append(newInterval)

        return res