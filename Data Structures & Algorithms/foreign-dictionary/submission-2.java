

class Solution {
    public String foreignDictionary(String[] words) {
        int n = words.length;
        final int K = 26; 

        // 1. Collect unique characters (stored as integer indices 0-25)
        Set<Integer> uniqIndices = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                uniqIndices.add(c - 'a'); // Storing index (0 for 'a', 1 for 'b', etc.)
            }
        }
        
        // ... (Graph Building and Topological Sort execution remain the same) ...
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";
            }

            int len = Math.min(s1.length(), s2.length());
            for (int ptr = 0; ptr < len; ptr++) {
                int u = s1.charAt(ptr) - 'a';
                int v = s2.charAt(ptr) - 'a';
                if (u != v) {
                    adj.get(u).add(v);
                    break;
                }
            }
        }

        // 2. Execute Topological Sort
        // The topoSort helper must now be adapted to use uniqIndices for initialization.
        List<Integer> topo = topoSort(K, adj, uniqIndices); // Passing uniqIndices here
        
        // 3. Final Check and String Construction
        if (topo.size() != uniqIndices.size()) {
            return ""; // Cycle detected
        }

        StringBuilder ans = new StringBuilder();
        // Iterate through the topological order
        for (int index : topo) {
            
            // 🌟 FINAL FIX: The topological sort already ensures the order, 
            // but we must check that the node was actually present in the input.
            // Since we initialized the queue in topoSort only with nodes from uniqIndices, 
            // the topo list *should* only contain relevant nodes, but checking the
            // original set provides robust filtering against stray nodes.
            
            if (uniqIndices.contains(index)) { 
                ans.append((char) (index + 'a'));
            }
        }
        
        return ans.toString();
    }

    // --- Adapted topoSort Helper Function ---
    private List<Integer> topoSort(int V, List<List<Integer>> adj, Set<Integer> uniqIndices) {
        int[] inDegree = new int[V];

        // Calculate In-Degrees only for nodes up to V-1 (25)
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        
        // Initialize queue ONLY with indices that appeared in the input words (uniqIndices) 
        // AND have an in-degree of 0. This is the crucial filter.
        for (int index : uniqIndices) { 
            if (inDegree[index] == 0) {
                q.add(index);
            }
        }

        List<Integer> topo = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        return topo;
    }
}