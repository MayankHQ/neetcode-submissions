class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        sc = []
        res = [0] * n
        for i in range(n):
            while (sc and temperatures[sc[-1]] < temperatures[i]):
                idx = sc.pop()
                res[idx] = i - idx
            sc.append(i)
        return res