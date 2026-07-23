class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>());
        return ans;
    }
    public void backtrack(int idx, int[] arr, int target, List<Integer> list){
        if(idx == arr.length){
            if(target == 0) ans.add(new ArrayList<>(list));
            return;
        }
        if(arr[idx] <= target){
            list.add(arr[idx]);
            backtrack(idx, arr, target - arr[idx], list);
            list.remove(list.size() - 1);
        }
        backtrack(idx+1, arr, target, list);
    }
}