class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        n = len(heights)
        maxarea = 0
        for i in range(n):
            ht = 1_000_000_000
            for j in range(i, n): 
                ht = min(ht, heights[j])
                width = j-i+1
                maxarea = max(maxarea, ht*width)
        return maxarea