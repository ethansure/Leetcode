import java.lang.*;

class Solution {
    public int projectionArea(int[][] grid) {
        int maxxy = 0;
        int maxxz = 0;
        int maxyz = 0;
        for(int i = 0; i < grid.length; i++) {
            int xz = 0, yz = 0, xy = 0;
            for(int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) xy++;
                xz = Math.max(xz, grid[i][j]);
                yz = Math.max(yz, grid[j][i]);
            }
            maxxy += xy;
            maxxz += xz;
            maxyz += yz;
        }
        
        return maxxy+ maxxz + maxyz;
    }
}