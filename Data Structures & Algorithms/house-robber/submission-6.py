class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1: return nums[0]
        if n == 2: return max(nums[0], nums[1])

        cache = {0 : nums[0], 1 : max(nums[0], nums[1])}

        def f(index):
            if index in cache:
                return cache[index]
            else:
                cache[index] = max(nums[index] + f(index-2), f(index-1))
                return cache[index]
        
        return f(n-1)


