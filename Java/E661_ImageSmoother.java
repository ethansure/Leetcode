class Solution {
    public int[][] imageSmoother(int[][] M) {
        int[][] smoothMatrix = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                smoothMatrix[i][j] = averageGrey(i, j, M);
            }
        }
        return smoothMatrix;
    }
    public int averageGrey(int x, int y, int[][] M) {
        int rows = M.length, cols = M[0].length;
        int ax = x - 1, ay = y - 1;
        int count = 0, grey = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ( ax >= 0 && ay >= 0 && ax < rows && ay < cols) {
                    count ++;
                    grey += M[ax][ay];
                }
                ay ++;
            }
            ax ++;
            ay = y - 1;
            
        }
        return (int) (grey / count);
    }
}