class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        n = len(nums)
        arr = [0] * (n*2)

        for i in range(n*2):
            arr[i] = nums[i%n]
        return arr