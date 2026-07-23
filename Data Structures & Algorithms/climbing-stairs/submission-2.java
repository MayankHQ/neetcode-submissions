class Solution {
    public int climbStairs(int n) {
        if(n == 0) return 1;
        int one = 1, two = 1;
        for(int i = 0; i < n; i++){
            int temp = two;
            two = one + two;
            one  = temp;
        }
        return one;
    }
}
