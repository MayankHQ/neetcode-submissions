class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;

        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0) return false;
        int target = sum / 2;

        Boolean[][] dp = new Boolean[n+1][target+1];
        for(Boolean[] row : dp){
            Arrays.fill(row, null);
        }

        return helper(nums, n, target, dp);
    }

    public boolean helper(int[] arr, int n, int target, Boolean[][] dp){
        if(target == 0) return true;
        if(n == 0) return false;
        if(dp[n][target] != null) return dp[n][target];
        if(arr[n-1] <= target){
            return dp[n][target] = helper(arr, n - 1, target - arr[n-1], dp) || helper(arr, n-1, target,dp);
        }
        else{
            return dp[n][target] = helper(arr, n-1, target, dp);
        }
    }
}
