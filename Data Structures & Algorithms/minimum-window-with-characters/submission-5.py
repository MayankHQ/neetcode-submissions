class Solution:
    def minWindow(self, s: str, t: str) -> str:
        hash = Counter(t)

        r = l = count = 0
        n, m = len(s), len(t)
        minlen = 1_000_000_000
        strtIdx = -1

        while r < n:
            if hash[s[r]] > 0:
                count += 1
            hash[s[r]] -= 1

            while count == m:
                if (r-l+1 < minlen):
                    minlen = r-l+1
                    strtIdx = l
                hash[s[l]] += 1

                if hash[s[l]] > 0:
                    count -= 1
                l += 1
            r += 1
        
        return "" if strtIdx == -1 else s[strtIdx : strtIdx + minlen] 