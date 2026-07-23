class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        
        int rob1 = 0;
        int rob2 = 0;

        for(int i = 0; i < n - 1; i++){
            int curr = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = curr;
        }
        int max1 = rob2;

        rob1 = 0;
        rob2 = 0;

        for(int i = 1; i < n; i++){
            int curr = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = curr;
        }
        int max2 = rob2;

        return Math.max(max1, max2);
    }
}
