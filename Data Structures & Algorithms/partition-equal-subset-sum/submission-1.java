class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        boolean[] dp = new boolean[n+1];
        Arrays.fill(dp, false);
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        return helper(nums, n, target, 0, dp);
    }

    public boolean helper(int[] arr, int n, int target, int idx, boolean[] dp){
        if(target == 0) return true;
        if(idx >= n) return false;
        if(dp[n] != false) return dp[n];
        boolean take = helper(arr, n, target - arr[idx], idx + 1, dp);
        boolean skip = helper(arr, n, target, idx + 1, dp);

        return dp[n] = take || skip;
    }
}
