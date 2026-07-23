class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length, r = 0, idx = 0;
        int[] arr = new int[n - k + 1];
        while(r < n){
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[r]){
                dq.pollLast();
            }
            dq.addLast(r);
            if(dq.peekFirst() <= r-k){
                dq.pollFirst();
            }
            if(r >= k-1){
                arr[idx++] = nums[dq.peekFirst()];
            }
            r++;

        }
        return arr;
    }
}
