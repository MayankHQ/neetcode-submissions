class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        n = len(heights)
        stack = []
        maxA = 0

        pse = [-1] * n
        for i in range(n):
            while(stack and heights[stack[-1]] >= heights[i]):
                stack.pop()
            if stack:
                pse[i] = stack[-1]
            stack.append(i)
        
        stack = []

        nse = [n] * n
        for i in range(n-1, -1, -1):
            while(stack and heights[stack[-1]] >= heights[i]):
                stack.pop()
            if stack:
                nse[i] = stack[-1]
            stack.append(i)
        
        for i in range(n):
            maxA = max(maxA, heights[i] * (nse[i] - pse[i] - 1))
        
        return maxA