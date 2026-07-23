class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        seen = set()
        for i in range(9):
            for j in range(9):
                curr = board[i][j]
                if curr != '.':
                    row_key = f"{curr} in row {i}"
                    col_key = f"{curr} in col {j}"
                    box_key = f"{curr} in box{i//3}{j//3}"

                    if (row_key in seen) or (col_key in seen) or (box_key in seen):
                        return False
                    seen.update([row_key, col_key, box_key])
        return True