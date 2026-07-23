class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int count = 1;
        int mx = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] + 1 == nums[i]){
                count++;
                mx = Math.max(mx, count); 
            }
            else if(nums[i-1] == nums[i]){
                continue;
            }
            else{
                count = 1;
            }
        }
        return mx;
    }
}
