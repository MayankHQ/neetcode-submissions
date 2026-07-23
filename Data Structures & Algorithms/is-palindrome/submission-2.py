class Solution:
    def isPalindrome(self, s: str) -> bool:
        n = len(s)
        start, end = 0, n-1
        while start < end:
            leftch, rightch = s[start], s[end]

            if not leftch.isalnum():
                start += 1
                continue

            if not rightch.isalnum():
                end -= 1
                continue
            
            if leftch.lower() != rightch.lower():
                return False
            
            start += 1
            end -= 1
        return True