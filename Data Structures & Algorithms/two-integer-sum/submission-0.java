class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        // for(int i = 0; i < nums.length; i++){
        //     hash.put(nums[i], i);
        // }
        for(int i = 0; i < nums.length; i++){
            int neg = target - nums[i];
            if(hash.containsKey(neg)){
                return new int[]{hash.get(neg),i};
            }
            hash.put(nums[i], i);
        }
        return new int[]{-1};
    }
}
