class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        count = {}
        res = 0

        l = maxf = 0

        for r in range(len(s)):
            count[s[r]] = 1 + count.get(s[r], 0)
            maxf = max(maxf, count[s[r]])

            #no. of replacements = length - maxFreq
            if (r-l+1) - maxf > k: #we dont need to use while because shrinking
                count[s[l]] -= 1  #will not help us as we want longest length
                l += 1
            res = max(res, r-l+1)

        return res
    
    #suppose s = "AABAB", k = 1
    # at l = 0, r = 4 we have length r-l+1 i.e 5 and maxF = 3 of A
    # if 5 - 3 > 1 i.e is true (5-3 means we have two replacement but we only can do 1)
    # remove freq of A from map and iterate l