class Solution {
    int row;
    int col;

    int[] DR = {-1, 1, 0, 0};
    int[] DC = {0, 0, -1, 1};

    public void solve(char[][] board) {
        row = board.length;
        col = board[0].length;
        int[][] vis = new int[row][col];

        for(int j = 0; j < col; j++){
            if(vis[0][j] == 0 && board[0][j] == 'O'){
                dfs(board, 0, j, vis);
            }

            if(vis[row - 1][j] == 0 && board[row - 1][j] == 'O'){
                dfs(board, row - 1, j, vis);
            }
        }

        for(int i = 0; i < row; i++){
            if(vis[i][0] == 0 && board[i][0] == 'O'){
                dfs(board, i, 0, vis);
            }

            if(vis[i][col-1] == 0 && board[i][col-1] == 'O'){
                dfs(board, i, col-1, vis);
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(vis[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void dfs(char[][] board, int r, int c, int[][] vis){
        vis[r][c] = 1;
        for(int i = 0; i < 4; i++){
            int nextR = r + DR[i];
            int nextC = c + DC[i];

            if(nextR >= 0 && nextR < row && nextC >= 0 && nextC < col && vis[nextR][nextC] == 0 && board[nextR][nextC] == 'O'){
                dfs(board, nextR, nextC, vis);
            }
        }
    }
}
