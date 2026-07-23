class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = 1; arr[n+1] = 1;
        for(int i = 0; i < n; i++){
            arr[i+1] = nums[i];
        }
        return fun(1, n, arr);
    }
    public int fun(int i, int j, int[] arr){
        if(i > j) return 0;
        int maxi = (int) -1e9;
        for(int idx = i; idx <= j; idx++){
            int cost = arr[i-1] * arr[idx] * arr[j+1] + fun(i, idx-1, arr) + fun(idx+1, j, arr);
            maxi = Math.max(maxi, cost);
        }
        return maxi;
    }
}
