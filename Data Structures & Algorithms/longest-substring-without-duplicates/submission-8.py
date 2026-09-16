class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:

        hash = set()
        l = maxlen = 0

        for r, char in enumerate(s):
            while char in hash:
                hash.remove(s[l])
                l += 1
            hash.add(s[r])
            maxlen = max(maxlen, r - l + 1)
        return maxlen