class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        n = len(heights)
        heights.append(0)
        stack = []
        maxarea = 0

        for i in range(n+1):
            while(stack and heights[stack[-1]] > heights[i]):
                idx = stack.pop()
                nse = i
                pse = -1 if not stack else stack[-1]
                maxarea = max(maxarea, heights[idx] * (nse - pse - 1))
            stack.append(i)
        
        # while stack:
        #     idx = stack.pop()
        #     nse = n
        #     pse = -1 if not stack else stack[-1]
        #     maxarea = max(maxarea, heights[idx] * (nse - pse - 1))
        
        return maxarea