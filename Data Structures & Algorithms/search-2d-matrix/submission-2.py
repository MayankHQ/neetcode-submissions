class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row = len(matrix)
        col = len(matrix[0])
        
        start, end = 0, row*col - 1

        while start <= end:
            mid = (start+end)//2
            midval = matrix[mid//col][mid%col]

            if midval == target:
                return True
            elif midval > target:
                end = mid - 1
            else:
                start = mid + 1
        return False