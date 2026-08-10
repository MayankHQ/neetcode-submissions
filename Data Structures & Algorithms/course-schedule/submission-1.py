class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        preMap = defaultdict(list)
        for course, prereq in prerequisites:
            preMap[course].append(prereq)
        
        visited = set()

        def dfs(curr_course):
            if curr_course in visited:
                return False
            if preMap[curr_course] == []:
                return True
            
            visited.add(curr_course)

            for pre in preMap[curr_course]:
                if not dfs(pre):
                    return False
            visited.remove(curr_course)
            preMap[curr_course] = []

            return True
        
        for c in range(numCourses):
            if not dfs(c):
                return False
        
        return True