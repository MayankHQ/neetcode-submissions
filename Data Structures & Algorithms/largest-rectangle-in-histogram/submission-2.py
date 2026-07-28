class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        n = len(heights)
        maxarea = 0

        # 1. Next Smaller Element INDICES
        nse = [n] * n
        stack = []
        for i in range(n - 1, -1, -1):
            while stack and heights[stack[-1]] >= heights[i]:
                stack.pop()
            
            nse[i] = n if not stack else stack[-1]
            stack.append(i)

        # 2. Previous Smaller Element INDICES
        pse = [-1] * n
        stack = []
        for i in range(n):
            while stack and heights[stack[-1]] >= heights[i]:
                stack.pop()
            
            pse[i] = -1 if not stack else stack[-1]
            stack.append(i)

        # 3. Calculate Max Area
        for i in range(n):
            width = nse[i] - pse[i] - 1
            maxarea = max(maxarea, width * heights[i])

        return maxarea