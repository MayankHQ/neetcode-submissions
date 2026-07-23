class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int maxLen = (int) -1e9;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < k; i++){
            maxLen = Math.max(maxLen, nums[i]);
        }
        list.add(maxLen);
        for(int i = 1; i <= n-k; i++){
            maxLen = (int)-1e9;
            for(int j = i; j < i+k; j++){
                maxLen = Math.max(maxLen, nums[j]);
            }
            list.add(maxLen);
        }
        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}
