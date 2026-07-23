class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //i can take min -> 1 banana/hr and max -> maximum in piles array 
        int mini = 1, maxi = (int)-1e9;
        for(int num : piles){
            maxi = Math.max(maxi, num);
        }

        while(mini <= maxi){
            int mid = mini + (maxi - mini)/2;
            long time = timetaken(piles, mid);
            //if time exceeding given h, it means koko eating too slow
            // increase its speed
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
        int totalHr = 0;
        for(int i = 0; i < arr.length; i++){
            //ceil value
            //for eg -> ceil(3.2) = 4, 4/3 = 1.33 but ceil is 2
            totalHr += (arr[i] + m - 1)/m; 
        }
        return totalHr;
    }
}
