class Solution:
    def trap(self, height: List[int]) -> int:
        s, e = 0, len(height) - 1
        ans = 0
        lmax = rmax = 0
        while s < e:
            if height[s] < height[e]:
                if height[s] < lmax:
                    ans += lmax - height[s]
                else:
                    lmax = height[s]
                s += 1
            else:
                if height[e] < rmax:
                    ans += rmax - height[e]
                else:
                    rmax = height[e]
                e -= 1
        
        return ans