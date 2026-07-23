class Solution {

    private int[] DR = {0,1,0,-1};
    private int[] DC = {1,0,-1,0};
    private int rows;
    private int cols;

    public int numIslands(char[][] grid) {

        if(grid.length ==  0 || grid == null) return 0;
        rows = grid.length;
        cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        int islandCount = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    islandCount++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return islandCount;
    }

    public void dfs(char[][] grid, boolean[][] visited, int r, int c){
        if(r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c] || grid[r][c] == '0') return;
        visited[r][c] = true;

        for(int i = 0; i < 4; i++){
            int nextR = r + DR[i];
            int nextC = c + DC[i];

            dfs(grid, visited, nextR, nextC);
        }
    }
}
