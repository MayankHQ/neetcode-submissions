class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, arr, ans, visited);
        return ans;
    }

    private void backtrack(int[] nums, List<Integer> temp, List<List<Integer>> ans, boolean[] visited) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            temp.add(nums[i]);
            backtrack(nums, temp, ans, visited);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}