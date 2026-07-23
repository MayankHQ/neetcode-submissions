class Solution {
    public int maxProduct(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            int ans = 1;
            for(int j = i; j < nums.length; j++){
                ans *= nums[j];
                maxi = Math.max(maxi, ans);
            }
        }
        return maxi;
    }
}
