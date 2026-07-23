class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;

        int start = 0, end = n-1;

        while(start < end){
            int minHt = Math.min(heights[start], heights[end]);
            int width = end - start;
            maxArea = Math.max(maxArea, minHt * width);
            if(heights[start] <= heights[end]){
                start++;
            }
            else{
                end--;
            } 
        }
        return maxArea;
    }
}
