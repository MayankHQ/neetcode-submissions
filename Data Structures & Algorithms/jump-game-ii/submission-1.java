class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int[] num : dp){
            Arrays.fill(num, -1);
        }
        return helper(nums,0,0, dp);
    }
    public int helper(int[] nums, int idx, int jumps, int[][] dp){
        if(idx >= nums.length - 1) return jumps;
        if(dp[idx][jumps] != -1) return dp[idx][jumps];
        int mini = Integer.MAX_VALUE;
        for(int i = 1; i <= nums[idx]; i++){
            mini = Math.min(mini, helper(nums, idx+i, jumps+1, dp));
        }
        return dp[idx][jumps] = mini;
    }
}
