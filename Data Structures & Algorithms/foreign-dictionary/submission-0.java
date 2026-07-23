
class Solution {
    public String foreignDictionary(String[] words) {
        int n = words.length;
        int k = 26; // assuming lowercase a-z

        // Collect all unique characters that actually appear
        Set<Character> uniq = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                uniq.add(c);
            }
        }

        // Build adjacency list for all k letters
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }

        // Build edges based on ordering in words
        for (int i = 0; i < n - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];

            int len = Math.min(s1.length(), s2.length());
            boolean foundDiff = false;

            for (int ptr = 0; ptr < len; ptr++) {
                char c1 = s1.charAt(ptr);
                char c2 = s2.charAt(ptr);
                if (c1 != c2) {
                    adj.get(c1 - 'a').add(c2 - 'a');
                    foundDiff = true;
                    break;
                }
            }

            // Prefix case: s1 is longer but has s2 as a prefix -> invalid
            if (!foundDiff && s1.length() > s2.length()) {
                return "";
            }
        }

        List<Integer> topo = topoSort(k, adj);

        // If there is a cycle, topo will miss some nodes.
        // We only care about nodes for chars that actually appear.
        // So we check how many of those appear in topo.
        Set<Character> inTopo = new HashSet<>();
        for (int it : topo) {
            char c = (char) (it + 'a');
            if (uniq.contains(c)) {
                inTopo.add(c);
            }
        }
        if (inTopo.size() < uniq.size()) {
            // some used characters not in topo => cycle/inconsistency
            return "";
        }

        // Build answer string only from characters that actually appear
        StringBuilder ans = new StringBuilder();
        for (int it : topo) {
            char c = (char) (it + 'a');
            if (uniq.contains(c)) {
                ans.append(c);
            }
        }
        return ans.toString();
    }

    private List<Integer> topoSort(int V, List<List<Integer>> adj) {
        int[] inDegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                inDegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for (int it : adj.get(node)) {
                inDegree[it]--;
                if (inDegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        return topo;
    }
}
