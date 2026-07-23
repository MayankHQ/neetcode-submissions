class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        left, right = 0, n-1
        leftmax, rightmax = height[left], height[right]
        area = 0

        while left < right:
            if leftmax <= rightmax:
                left += 1 #as the first index cant store water we skip it
                leftmax = max(leftmax, height[left])
                area += leftmax - height[left] 
            else:
                right -= 1 #as the last index cant store water we skip it
                rightmax = max(rightmax, height[right])
                area += rightmax - height[right]
        return area