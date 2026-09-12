class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = 0, c = matrix[0].length-1;
        while(r < matrix.length && c >= 0){
            int val = matrix[r][c];
            if(val == target){
                return true;
            }else if(val < target){
                r++;
            }else{
                c--;
            }
        }
        return false;
    }
}
