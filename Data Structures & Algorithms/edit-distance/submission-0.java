class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(m, n, word1, word2, dp);
    }
    public int helper(int i, int j, String a, String b, int[][] dp){
        if(i == 0) return j;
        if(j == 0) return i;
        if(dp[i][j] != -1) return dp[i][j];
        if(a.charAt(i-1) == b.charAt(j-1)){
            return helper(i-1, j-1, a, b, dp);
        }
        int insert = helper(i, j-1, a,b, dp);
        int delete = helper(i-1, j, a, b, dp);
        int replace = helper(i-1, j-1, a,b, dp);
        return dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
    }
}