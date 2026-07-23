class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new LinkedList<>();
        int[] ans = new int[n-k+1];
        int idx = 0;

        for(int i = 0; i < n; i++){
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(dq.peekFirst() < i - k + 1){
                dq.pollFirst();
            }
            if(i >= k-1){
                ans[idx++] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}
