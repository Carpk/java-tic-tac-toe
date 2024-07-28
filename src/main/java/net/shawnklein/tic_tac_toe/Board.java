package net.shawnklein.tic_tac_toe;

public class Board {
  String[] board;

  public Board(String[] gameBoard) {
    board = gameBoard;

  }


  public boolean isActive() {
    // need to check for winning positions
    for (String s : board) {
      if (" ".equals(s)) {
        return true;
      }
    }

    return false;
  }






  public boolean isColMatch() {
    
    boolean a = board[0].equals(board[3]) && board[0].equals(board[6]);
    boolean b = board[1].equals(board[4]) && board[1].equals(board[7]);
    boolean c = board[2].equals(board[5]) && board[2].equals(board[8]);

    System.out.printf("MIDDLE COL: %b", b);
    System.out.printf("%s %s %s", board[1], board[4], board[7] );

    return false;
  }
}
