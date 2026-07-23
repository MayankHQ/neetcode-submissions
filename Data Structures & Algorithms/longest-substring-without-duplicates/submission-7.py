class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)
        hash = {}
        left = 0
        longest = 0

        for right in range(n):
            c = s[right]
            if c in hash:
                left = max(left, hash[c] + 1)
            hash[c] = right
            longest = max(longest, right-left+1)
        
        return longest