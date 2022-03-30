
/*Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.*/




class SeachInSortedMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length, c = matrix[0].length, low = 0, high = r-1;
        int rowNum = 0;
        while (low < high) {
            int mid = low + (high -low + 1)/2;
            if (matrix[mid][0] <= target && matrix[mid][c-1] >= target) {
                rowNum = mid;
                break;
            }
            else if (matrix[mid][0] > target)
                high = mid - 1;
            else 
                low = mid;
        }
        System.out.println("row :"+ rowNum);
        
        low = 0;
        high = c-1;
        while (low <= high) {
            int mid = low + (high -low)/2;
            if (matrix[rowNum][mid] == target) {
                return true;
            }
            else if (matrix[rowNum][mid] > target)
                high = mid - 1;
            else 
                low = mid + 1;;
        }
        return false;
    }
}