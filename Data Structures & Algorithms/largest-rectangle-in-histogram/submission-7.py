# class Solution:
#     def largestRectangleArea(self, heights: List[int]) -> int:
#         n = len(heights)
#         heights.append(0) #sentinel logic
#         stack = []
#         maxarea = 0

#         for i in range(n+1):
#             while(stack and heights[stack[-1]] > heights[i]):
#                 idx = stack.pop()
#                 nse = i
#                 pse = -1 if not stack else stack[-1]
#                 maxarea = max(maxarea, heights[idx] * (nse - pse - 1))
#             stack.append(i)
        
#         # while stack:  //this was basically for the case where array was in increasing order
#         #     idx = stack.pop()
#         #     nse = n
#         #     pse = -1 if not stack else stack[-1]
#         #     maxarea = max(maxarea, heights[idx] * (nse - pse - 1))
        
#         return maxarea

class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        maxarea = 0
        n = len(heights)
        sc = []

        nse = [n] * n
        pse = [-1] * n

        for i in range(n-1, -1 , -1):
            while sc and heights[sc[-1]] >= heights[i]:
                sc.pop()
            if sc:
                nse[i] = sc[-1]
            sc.append(i)
        
        sc.clear()

        for i in range(n):
            while sc and heights[sc[-1]] >= heights[i]:
                sc.pop()
            if sc:
                pse[i] = sc[-1]
            sc.append(i)
        
        for i in range(n):
            maxarea = max(maxarea, heights[i] * (nse[i] - pse[i] - 1))
        
        return maxarea

