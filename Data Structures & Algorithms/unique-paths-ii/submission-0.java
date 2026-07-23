class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(m-1, n-1, obstacleGrid, dp);
    }
    public int helper(int i, int j, int[][] matrix, int[][] dp){
        if(i >= 0 && j >= 0 && matrix[i][j] == 1) return 0;
        if(i < 0 || j < 0) return 0;
        if(i == 0 && j == 0) return 1;

        if(dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = helper(i-1, j, matrix, dp) + helper(i, j-1, matrix, dp);
    }
}