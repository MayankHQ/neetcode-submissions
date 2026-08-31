class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        adjlist = defaultdict(list)
        visit = [False] * n
        for u, v in edges:
            adjlist[u].append(v)
            adjlist[v].append(u)

        cnt = 1
        
        def dfs(node):
            for nei in adjlist[node]: #j = neighbors
                if not visit[nei]:
                    visit[nei] = True
                    dfs(nei)
        cnt = 0
        
        for node in range(n):
            if not visit[node]:
                visit[node] = True
                dfs(node)
                cnt += 1
        return cnt
   