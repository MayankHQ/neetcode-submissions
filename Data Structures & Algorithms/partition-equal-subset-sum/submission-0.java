class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        return helper(nums, nums.length, target, 0);
    }

    public boolean helper(int[] arr, int n, int target, int idx){
        if(target == 0) return true;
        if(idx >= n) return false;

        boolean take = helper(arr, n, target - arr[idx], idx + 1);
        boolean skip = helper(arr, n, target, idx + 1);

        return (take || skip);
    }
}
