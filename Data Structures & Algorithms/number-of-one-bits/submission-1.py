class Solution:
    def hammingWeight(self, n: int) -> int:
        cnt = 0
        while n > 0:
            cnt += n&1 #res += 1 if n & 1 else 0
            n = n >> 1
        return cnt