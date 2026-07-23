class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        int rob1 = nums[0], rob2 = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++){
            int take = nums[i] + rob1;
            int skip = rob2;
            int curr = Math.max(take, skip);

            rob1 = rob2;
            rob2 = curr;
        }
        return rob2;
    }
}
