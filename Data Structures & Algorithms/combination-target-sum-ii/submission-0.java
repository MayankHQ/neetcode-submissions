// class Solution {

//     public List<List<Integer>> combinationSum2(int[] nums, int target) {
//         List<List<Integer>> combination = new ArrayList<>();
//         List<Integer> curr = new ArrayList<>();
//         backtrack(nums,target,0, combination, curr);
//         return combination;
//     }
//     private void backtrack(int[] nums, int target, int index, List<List<Integer>> combination, List<Integer> curr){
//         if(target == 0){
//             combination.add(new ArrayList<>(curr));
//             return;
//         }

//         if(target < 0 || index == nums.length) return;
        
//         curr.add(nums[i]);
//         backtrack(nums, target- nums[i], i+1, combination, curr);
//         curr.remove(curr.size() - 1);
        

//     }
// }

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> combinationSet = new HashSet<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(candidates, target, 0, curr, combinationSet);
        
        // Convert Set to List before returning
        return new ArrayList<>(combinationSet);
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> curr, Set<List<Integer>> combinationSet) {
        if (target == 0) {
            // Sort combination to normalize and prevent duplicates like [1,2] and [2,1]
            List<Integer> sortedCombo = new ArrayList<>(curr);
            Collections.sort(sortedCombo);
            combinationSet.add(sortedCombo);
            return;
        }
        
        if (target < 0) return;

        for (int i = start; i < candidates.length; i++) {
            curr.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, curr, combinationSet);
            curr.remove(curr.size() - 1);
        }
    }
}

