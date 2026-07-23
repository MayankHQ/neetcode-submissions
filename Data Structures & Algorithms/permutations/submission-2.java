class Solution {
    boolean[] visited;
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        visited = new boolean[nums.length];
        recurse(nums, new ArrayList<>());
        return res;
    }
    public void recurse(int[] arr, List<Integer> ans){
        if(ans.size() == arr.length){
            res.add(new ArrayList<>(ans));
            return;
        }

        for(int i = 0; i < arr.length; i++){
            if(!visited[i]){
                ans.add(arr[i]);
                visited[i] = true;
                recurse(arr, ans);

                ans.remove(ans.size() - 1);
                visited[i] = false;
            }
        }
    }
}
