import java.lang.*;

class Solution {
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int r = board.length;
        int c = board[0].length;
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                int n = lifeOfNeighb(board, i, j);
                if (board[i][j] == 1 && n >= 2 && n <= 3) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && n == 3) {
                    board[i][j] = 2;
                }
            }
        }
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                board[i][j] >>= 1;
            }
        }
    }
    
    public int lifeOfNeighb(int[][] board, int r, int c) {
        int lives = 0;
        
        for(int i = Math.max(r-1,0); i <= Math.min(r+1, board.length - 1); i++) {
            for(int j = Math.max(c-1, 0); j <= Math.min(c+1, board[0].length - 1); j++) {
                if (i == r && j == c) {
                    continue;
                }
                if ((board[i][j] & 1) == 1) {
                    lives += (board[i][j] & 1);
                }
            }
        }
        return lives;
    }
}