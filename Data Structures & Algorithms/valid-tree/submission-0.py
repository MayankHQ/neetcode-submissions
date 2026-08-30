class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if not n:
            return False
        
        adj = defaultdict(list)
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)
        
        visit = set()

        def dfs(curr, prev):
            if curr in visit:
                return False
            
            visit.add(curr)
            for nei in adj[curr]:
                if nei == prev:
                    continue
                if not dfs(nei, curr):
                    return False
            return True
        return dfs(0, -1) and len(visit) == n