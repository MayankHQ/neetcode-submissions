class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        subset = []
        def recurse(idx):
            if idx == len(nums):
                res.append(subset.copy())
                return
            
            subset.append(nums[idx])
            recurse(idx+1)
            subset.pop()
            recurse(idx+1)
        recurse(0)

        return res
