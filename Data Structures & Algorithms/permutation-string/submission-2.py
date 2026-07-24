class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        n1 = len(s1)
        s1 = sorted(s1)

        for i in range(len(s2) - n1 + 1):
            sub_str = sorted(s2[i: i+n1])
            if(s1 == sub_str):
                return True
        
        return False

