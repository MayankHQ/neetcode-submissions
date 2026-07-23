class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];

        int case1 = dpHelper(nums, 0, n-2, new int[n]);
        int case2 = dpHelper(nums, 1, n-1, new int[n]);

        return Math.max(case1, case2);
    }
    public int dpHelper(int[] nums, int start, int end, int[] dp){
        Arrays.fill(dp, -1);
        return helper(nums, start, end, dp);
    }
    public int helper(int[] nums, int start, int end, int[] dp ){
        if(start > end) return 0;
        if(dp[start] != -1){
            return dp[start];
        }
        int rob = nums[start] + helper(nums, start + 2, end, dp);
        int skip = helper(nums, start + 1, end, dp);

        return dp[start] = Math.max(rob,skip);
    }
}
