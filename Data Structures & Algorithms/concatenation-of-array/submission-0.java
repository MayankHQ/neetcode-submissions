class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] newArr = new int[2*n];
        for(int i = 0; i < n; i++){
            newArr[i] = nums[i];
            newArr[i+n] = nums[i];
        }
        return newArr;
    }
}