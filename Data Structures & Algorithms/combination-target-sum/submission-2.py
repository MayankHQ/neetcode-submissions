class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []
        sub = []
        def dfs(idx, target):
            if idx == len(nums):
                if target == 0:
                    res.append(sub.copy())
                return
            
            if nums[idx] <= target:
                sub.append(nums[idx])
                dfs(idx, target - nums[idx])
                sub.pop()
            dfs(idx+1, target)
        dfs(0, target)
        return res