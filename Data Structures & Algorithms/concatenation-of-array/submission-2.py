class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        arr = []
        for _ in range(2):
            arr.extend(nums)
        return arr