public class Solution {
    private static List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res.clear();
        Arrays.sort(candidates);
        dfs(0, new ArrayList<>(), candidates, target);
        return res;
    }

    private static void dfs(int idx, List<Integer> path, int[] candidates, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (target - candidates[i] < 0) {
                break;
            }

            path.add(candidates[i]);
            dfs(i + 1, path, candidates, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}