class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []
        sub = []
        def dfs(idx, target):
            if idx == len(nums):
                if target == 0:
                    res.append(sub.copy())
                return
            
            #Include nums[idx] (can reuse the same element!)
            if nums[idx] <= target:
                sub.append(nums[idx])
                dfs(idx, target - nums[idx]) #Stay at idx
                sub.pop() #Backtrack
            #Exclude nums[idx] (move to next element)
            dfs(idx+1, target)
        dfs(0, target)
        return res