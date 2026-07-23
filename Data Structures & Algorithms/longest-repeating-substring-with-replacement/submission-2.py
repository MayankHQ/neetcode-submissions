class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        n = len(s)
        res = 0
        for i in range(n):
            hash, maxf = {}, 0
            for j in range(i, n):
                hash[s[j]] = 1 + hash.get(s[j], 0)
                maxf = max(maxf, hash[s[j]])

                if(j-i+1) - maxf <= k:
                    res = max(res, j-i+1)
        return res