class Solution {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> combination = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(nums,target,0, combination, curr);
        return combination;
    }
    private void backtrack(int[] nums, int target, int index, List<List<Integer>> combination, List<Integer> curr){
        if(target == 0){
            combination.add(new ArrayList<>(curr));
            return;
        }

        if(target < 0 || index == nums.length) return;
        
        for(int i = index; i < nums.length; i++){
            curr.add(nums[i]);
            backtrack(nums, target- nums[i], i, combination, curr);
            curr.remove(curr.size() - 1);
        }

    }
}
