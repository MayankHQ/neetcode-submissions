class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        //q stores coordinates as [row, colmn]
        Queue<int[]> q = new LinkedList<>();
        int countFresh = 0;
        int time = 0;

        //initialize: find rotten oranges and count fresh one initially
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
                else if(grid[i][j] == 1){
                    countFresh++;
                }
            }
        }
        if(countFresh == 0) return 0;
        
        //intialize direction row and column
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        //bfs traversal
        while(!q.isEmpty() && countFresh > 0){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int j = 0; j < 4; j++){
                    int nR = r + dRow[j];
                    int nC = c + dCol[j];

                    if(nR >= 0 && nR < row && nC >= 0 && nC < col && grid[nR][nC] == 1){
                        grid[nR][nC] = 2;
                        countFresh--;
                        q.offer(new int[]{nR, nC});
                    }
                }
            }
            time++;
        }
        return (countFresh == 0) ? time: -1;
    }
}
