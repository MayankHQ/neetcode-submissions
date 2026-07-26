class Solution:
    def isValid(self, s: str) -> bool:
        stack = []

        for i in range(len(s)):
            ch = s[i]
            if(ch == '(' or ch == '{' or ch == '['):
                stack.append(ch)
            else:
                if not stack:
                    return False
                top = stack[-1]
                if (ch == ')'and top != '(') or (ch == ']'and top != '[') or (ch == '}'and top != '{'):
                    return False
                stack.pop()
        return not stack