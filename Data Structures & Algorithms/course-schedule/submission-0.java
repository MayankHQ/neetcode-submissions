class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int V = numCourses;
        int[] inDegree = new int[V];
        
        for(int i = 0; i < V; i++){
            for(int it : adj.get(i)){
                inDegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        int cnt = 0;        
        while(!q.isEmpty()){
            int node = q.poll();
            cnt++;

            for(int it : adj.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0){
                    q.add(it);
                }
            }
        }
        return (cnt == V)? true : false;
    }
}
