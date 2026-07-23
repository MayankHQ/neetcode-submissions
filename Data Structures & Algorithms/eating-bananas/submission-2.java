class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int mini = 1, maxi = (int)-1e9;
        for(int num : piles){
            maxi = Math.max(maxi, num);
        }

        while(mini <= maxi){
            int mid = mini + (maxi - mini)/2;
            long time = timetaken(piles, mid);
            if(time > h){
                mini = mid+1;
            }
            else{
                maxi = mid-1;
            }
        }
        return mini;
    }
    public int timetaken(int[] arr, int m){
        int cnt = 0;
        for(int i = 0; i < arr.length; i++){
            cnt += (arr[i] + m - 1)/m;
        }
        return cnt;
    }
}
