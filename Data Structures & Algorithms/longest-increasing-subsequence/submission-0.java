class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int maxi = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i = 0; i < n; i++){
            for(int prev = 0; prev < i; prev++){
                if(nums[i] > nums[prev]){
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;

    }
}
