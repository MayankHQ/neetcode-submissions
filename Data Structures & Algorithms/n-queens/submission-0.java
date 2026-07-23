class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] ch : board){
            Arrays.fill(ch, '.');
        }
        solve(n, board, 0, ans);
        return ans;
    }

    public void solve(int n, char[][] board, int row, List<List<String>> ans){
        if(row == n){
            ans.add(display(board));
            return;
        }

        for(int col = 0; col < n; col++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                solve(n, board, row+1, ans);
                board[row][col] = '.'; 
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col){
        //vertical check
        for(int i = 0; i < row; i++){
            if(board[i][col] == 'Q') return false;
        }

        //upper left diagonal
        for(int i = row,j = col; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 'Q') return false;
        }

        //upper right diagonal
        for(int i = row, j = col; i >= 0 && j < board.length; i--,j++){
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }

    private List<String> display(char[][] board){
        List<String> ans = new ArrayList<>();
        for(char[] row : board){
            ans.add(new String(row));
        }
        return ans;
    }
}
