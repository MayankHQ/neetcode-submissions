class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False
        
        winFreq, patFreq = [0] * 26, [0] * 26

        for i in range(len(s1)):
            winFreq[ord(s2[i]) - ord('a')] += 1
            patFreq[ord(s1[i]) - ord('a')] += 1
        
        if(winFreq == patFreq):
            return True
        
        for i in range(len(s1), len(s2)):
            winFreq[ord(s2[i]) - ord('a')] += 1
            winFreq[ord(s2[i - len(s1)]) - ord('a')] -= 1
            if(winFreq == patFreq):
                return True
        
        return False