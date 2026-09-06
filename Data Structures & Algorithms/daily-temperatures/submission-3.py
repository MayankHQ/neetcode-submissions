# class Solution:
#     def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
#         n = len(temperatures)
#         sc = []
#         res = [0] * n
#         for i in range(n):
#             while (sc and temperatures[sc[-1]] < temperatures[i]):
#                 idx = sc.pop()
#                 res[idx] = i - idx
#             sc.append(i)
#         return res
    
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        if n == 1:
            return [0]
        res = [0] * n
        q = deque()

        for i in range(n-1, -1, -1):
            while q and temperatures[q[-1]] <= temperatures[i]:
                q.pop()
            
            if q and temperatures[q[-1]] > temperatures[i]:
                res[i] = q[-1] - i

            q.append(i)
            
            
        return res