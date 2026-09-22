class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(t) > len(s):
            return ""
        hash = [0] * 128
        for c in t:
            hash[ord(c)] += 1
        l = strtIdx = count = 0
        minlen = float('inf')

        for r in range(len(s)):
            if hash[ord(s[r])] > 0:
                count += 1
            hash[ord(s[r])] -= 1

            while count == len(t):
                if minlen > r-l+1:
                    minlen = r-l+1
                    strtIdx = l
                hash[ord(s[l])] += 1
                if hash[ord(s[l])] > 0:
                    count -= 1
                l += 1
        
        return "" if minlen == float('inf') else s[strtIdx : strtIdx + minlen]