class Solution {
    public int jump(int[] nums) {
        return helper(nums,0,0);
    }
    public int helper(int[] nums, int idx, int jumps){
        if(idx >= nums.length - 1) return jumps;
        int mini = Integer.MAX_VALUE;
        for(int i = 1; i <= nums[idx]; i++){
            mini = Math.min(mini, helper(nums, idx+i, jumps+1));
        }
        return mini;
    }
}
