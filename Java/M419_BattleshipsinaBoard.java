class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        for( int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    char right = '.';
                    char down = '.';
                    if ( i + 1 < board.length) {
                        down = board[i + 1][j];
                    }
                    if (j + 1 < board[0].length) {
                        right = board[i][j + 1];
                    }
                    if (right == '.' && down == '.') {
                        count ++;
                    }
                    
                }
            }
        }
        return count;
    }
}