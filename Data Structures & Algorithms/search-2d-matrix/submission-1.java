class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int r = n - 1;
        int c = 0;

        while(r >= 0 && c < m) {
            int curr = matrix[r][c];

            if(curr == target) {
                return true;
            }

            if(curr > target) {
                r--;
            } else {
                c++;
            }
        }

        return false;
    }
}
