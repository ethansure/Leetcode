class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> spiralnums = new ArrayList<Integer>();
        if (matrix.length == 0) {
            return spiralnums;
        }
        int[][] visited = new int[matrix.length][matrix[0].length];
        spiralTraverse(spiralnums, matrix, visited, 0, 0, matrix.length * matrix[0].length);
        return spiralnums;
    }
    private void spiralTraverse(List<Integer> l, int[][] matrix, int[][] visited, int i, int j, int remain) {
        while(j < matrix[0].length && visited[i][j] != 1) {
            l.add(matrix[i][j]);
            visited[i][j] = 1;
            remain--;
            j ++;
        }
        j--;
        i++;
        while(i < matrix.length && visited[i][j] != 1) {
            l.add(matrix[i][j]);
            visited[i][j] = 1;
            remain--;
            i ++;
        }
        i--;
        j--;
        while(j >= 0 && visited[i][j] != 1) {
            l.add(matrix[i][j]);
            visited[i][j] = 1;
            remain--;
            j --;
        }
        j++;
        i--;
        while(i >= 0 && visited[i][j] != 1) {
            l.add(matrix[i][j]);
            visited[i][j] = 1;
            remain--;
            i --;
        }
        i++;
        j++;
        if(remain > 0) {
            spiralTraverse(l,matrix,visited,i,j,remain);    
        } else {
            return;
        }
        
    }
}