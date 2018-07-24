import java.lang.*;

class Solution {
    public int binarySearch(int[] arr, int low, int high, int target) {
        if(low > high) {
            return low - 1;
        } else {
            int mid = (low + high) / 2;
            if (arr[mid] < target) {
                return binarySearch(arr, mid + 1, high, target);
            } else if (arr[mid] > target){
                return binarySearch(arr, low, mid - 1, target);
            } else {
                return mid;
            }
        }
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int[] firstColumn = new int[matrix.length];
        for(int i = 0; i < firstColumn.length; i++) {
            firstColumn[i] = matrix[i][0];
        }
        int ci = binarySearch(matrix[0], 0, matrix[0].length - 1, target);
        int ri = binarySearch(firstColumn, 0, matrix.length - 1, target);
        if (ci < 0 || ri < 0) {
            return false;
        }
        
        int rhigh = Math.min(firstColumn.length - 1, ri);
        int chigh = Math.min(matrix[0].length - 1, ci);
        
        for (int r = rhigh; r >=0; r--) {
            int idx = binarySearch(matrix[r], 0, chigh, target);
            if (idx >= 0 &&  idx <= chigh && matrix[r][idx] == target) {
                return true;
            }
        }
           
        return false;
        
    }
}