class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        adj = defaultdict(list)
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)
        visit = [False] * n
        cnt = 0

        def dfs(node):  
            for nei in adj[node]:
                if not visit[nei]:
                    visit[nei] = True
                    dfs(nei)

        for node in range(n):
            if not visit[node]:
                visit[node] = True       
                dfs(node)
                cnt += 1
        return cnt