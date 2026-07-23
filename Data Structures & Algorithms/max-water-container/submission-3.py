class Solution:
    def maxArea(self, heights: List[int]) -> int:
        n = len(heights)
        start, end = 0, n-1
        area = 0

        while start < end:
            width = end-start
            ht = min(heights[start], heights[end])

            if heights[start] < heights[end]:
                start += 1
            else:
                end -= 1
            
            area = max(area, ht*width)
        
        return area