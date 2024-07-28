package net.shawnklein.tic_tac_toe;

public class Board {
  String[] board;

  public Board(String[] gameBoard) {
    board = gameBoard;

  }

  // need to check for winning positions or full board
  public boolean isActive() {
    return !isColMatch() && !isRowMatch();
  }



  public boolean isFullBoard() {
    for (String s : board) {
      if (" ".equals(s)) { return false; }
    }

    return true;
  }


  public boolean isColMatch() {
    boolean a = !board[0].equals(" ") && board[0].equals(board[3]) && board[0].equals(board[6]);
    boolean b = !board[1].equals(" ") && board[1].equals(board[4]) && board[1].equals(board[7]);
    boolean c = !board[2].equals(" ") && board[2].equals(board[5]) && board[2].equals(board[8]);

    return a || b || c;
  }

  public boolean isRowMatch() {
    String top = board[0];
    String mid = board[3];
    String bot = board[6];

    boolean a = !top.equals(" ") && top.equals(board[1]) && top.equals(board[2]);
    boolean b = !mid.equals(" ") && mid.equals(board[4]) && mid.equals(board[5]);
    boolean c = !bot.equals(" ") && bot.equals(board[7]) && bot.equals(board[8]);

    return a || b || c;
  }

  public boolean isDiagMatch() {
    boolean a = !board[0].equals(" ") && board[0].equals(board[4]) && board[0].equals(board[8]);
    boolean b = !board[2].equals(" ") && board[2].equals(board[4]) && board[2].equals(board[6]);

    return a || b;
  }
}
