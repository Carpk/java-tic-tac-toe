package net.shawnklein.tic_tac_toe;

public class Opponent {



  public Opponent() {

  }



  // manages the ai algorithm
  // returns suggsted position
  public int play(Board board) {
    int pos = 0;
    int max = -128;

    for (int i = 0; i < 9; i++) {
      if (board.isBlank(i)) {
        int nextplay = simPlayerTurn(board) / 2;
        if (max < nextplay) {
          pos = i; 
        }
      }
    }

    return pos;
  }

  
  public int simPlayerTurn(Board board) {
    for (int i = 0; i < 9; i++) {
      if (board.isBlank(i)) {
          int nextplay = simPlayerTurn(board) / 2;
      }
    }

    return 0;
  }
  
  public Integer minimax(Board board, int depth, Boolean maximizingPlayer) {
    if (depth == 0) 
      if (board.pcWins()) {
        return 128;
      } else {
        return -128;
      }
    if (maximizingPlayer) {
      int value = -128;

      // could just get list of indices
      for (int i = 0; i < 9; i++) {
        if (board.isBlank(i)) {
          board.assign(i, "O");
          value = Math.max(value, minimax(board, depth - 1, false));
        }
      }

      return value;
    } else { //minimizing player
        int value = 128;
        for (int i = 0; i < 9; i++) {
          board.assign(i, "X");
          value = Math.min(value, minimax(board, depth - 1, true));
        }
        return value;
    }
  }

}
