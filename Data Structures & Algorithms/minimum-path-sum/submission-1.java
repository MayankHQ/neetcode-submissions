class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(grid.length - 1, grid[0].length - 1, grid, dp);
    }
    public int helper(int i, int j, int[][] mat, int[][] dp){
        if(i == 0 && j == 0) return mat[0][0];
        if(i < 0 || j < 0) return (int)1e9;
        if(dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = mat[i][j] + Math.min(helper(i-1, j, mat, dp), helper(i, j-1, mat, dp));
    }
}