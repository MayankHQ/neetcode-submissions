class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int idx = stack.pop();
                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, heights[idx] * (nse - pse - 1));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int idx = stack.pop();
            int nse = n;
            int pse = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, heights[idx] * (nse - pse - 1));
        }

        return maxArea;

    }
}
