class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxNormal = kadane(nums);
        int totalSum = 0;
        for(int i = 0; i < nums.length; i++){
            totalSum += nums[i];
            nums[i] = -nums[i];
        }

        int maxInverted = kadane(nums);
        int circularSum = totalSum + maxInverted;

        if(circularSum == 0) return maxNormal;

        return Math.max(circularSum, maxNormal);
    }
    private int kadane(int[] nums){
        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        for(int num : nums){
            sum += num;
            if(maxi < sum){
                maxi = sum;
            }
            if(sum < 0) sum = 0;
        }
        return maxi;    }
}