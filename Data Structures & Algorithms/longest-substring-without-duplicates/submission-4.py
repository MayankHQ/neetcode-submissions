class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)
        hash = set()
        left = 0
        longest = 0
        
        for right in range(n):
            c = s[right]
            while c in hash:
                hash.remove(s[left])
                left += 1
            hash.add(c)
            longest = max(longest, right-left+1)
        
        return longest