class Solution {
    public int maxArea(int[] heights) {
        int maxi = 0;
        int n = heights.length;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int minHt = Math.min(heights[i], heights[j]);
                int width = j-i;
                maxi = Math.max(maxi, minHt*width);
            }
        }
        return maxi;
    }
}
