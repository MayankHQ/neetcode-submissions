class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hash = {}
        for i, n in enumerate(nums):
            neg = target - n
            if neg in hash:
                return [hash[neg], i]
            hash[n] = i