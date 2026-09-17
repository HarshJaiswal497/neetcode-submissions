class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, bot = m - 1;
        while (top <= bot) {
            int row = top + (bot - top) / 2;
            if (target > matrix[row][n-1]) {
                top = row + 1;
            } else if (target < matrix[row][0]) {
                bot = row - 1;
            } else {
                break;
            }
        }
        if (top > bot) {
            return false;
        }
        int row = top + (bot - top) / 2;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == matrix[row][mid]) {
                return true;
            } else if (target > matrix[row][mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
