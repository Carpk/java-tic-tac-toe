package net.shawnklein.tic_tac_toe;

public class Board {
  String[] board;

  public Board(String[] gameBoard) {
    board = gameBoard;

  }

  public int availableSpaces() {
    int res = 0;

    for (int i=0; i<9; i++) {
        if (" " == board[i]) {
          res++;
        }
    }
    return res;
  }

  // need to check for winning positions or full board
  public boolean isActive() {
    return !isColMatch() && !isRowMatch();
  }

  // method to return boolean 
  // set instance var if winner available
  public String winner() {
    return " ";
  }


  // returns boolean based on playable positions in board
  public boolean isFullBoard() {
    for (String s : board) {
      if (" ".equals(s)) { return false; }
    }

    return true;
  }

  // possibly change these to return common character
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



  public boolean isBlank(int i) {
    return board[i].equals(" ");
  }

  public boolean pcWins() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'pcWins'");
  }

  public void assign(int i, String string) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'assign'");
  }
}