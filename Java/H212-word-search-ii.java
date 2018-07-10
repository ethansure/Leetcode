
class Solution {
  public static boolean[][] visited;
  public List<String> findWords(char[][] board, String[] words) {
      Set<String> wordsSet = Arrays.stream(words).collect(Collectors.toSet());
      List<String> boardWords = new ArrayList<>();
      int wi = 1;
      for(String word:wordsSet) {
          wi++;
          if (word.length() > board.length * board[0].length) {
              break;
          }
          if (matchWord(board, word)) {
              boardWords.add(word);
          }
      }
      return boardWords;
     
  }
  public boolean matchWord(char[][] board, String word) {
      visited = new boolean[board.length][board[0].length];
      for (int i = 0; i < board.length; i++) {
          for (int j = 0; j < board[0].length; j ++) {
              if(match(word, 0, i, j, board)){
                 return true;
              }
          }
      }
      return false;
  }
      
  public boolean match(String word, int index, int i, int j, char[][] board) {
      if (index == word.length()) {
          return true;
      }
      if (i >= board.length || i < 0) {
          return false;
      }
      if (j >= board[0].length || j < 0) {
          return false;
      }
      if (visited[i][j]) {
          return false;
      }
      if (board[i][j] == word.charAt(index)) {
          visited[i][j] = true;
          boolean r = match(word, index + 1, i + 1, j, board) 
              || match(word, index + 1, i - 1, j, board)
              || match(word, index + 1, i, j + 1, board)
              || match(word, index + 1, i, j - 1, board);
          visited[i][j] = r;
          return r;
      } else {
          visited[i][j] = false;
          return false;
      }
  }
}