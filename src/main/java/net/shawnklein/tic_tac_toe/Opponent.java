package net.shawnklein.tic_tac_toe;

public class Opponent {



  public Opponent() {

  }






  // manages the ai algorithm by deciding is position is appropriate
  // based on heuristic, returns suggsted position
  public int play(Board board) {
    int pos = 0;
    int maxVal = -128;
    int depth = board.availableSpaces(); // - 1;

    for (int i = 0; i < 9; i++) {
      if (board.isBlank(i)) {
        Board tempBoard = board.clone();
        tempBoard.assign(i, "X");

        int posValue = minimax(tempBoard, depth, false);
        System.out.println("RETURNING VAL: " + posValue);         // PRINT FOR DEBUG

        if (maxVal < posValue) {
          pos = i; 
        }
      }
    }

    return pos;
  }
  

  public Integer minimax(Board board, int depth, Boolean pcTurn) {
    if (depth == 0 || board.isAnyMatch()) {
      if (board.pcWins()) {
        return 128;               
      } else if (board.huWins()) {
        return -128;
      } else {                                                // need check for tie game, else if pWin r 0
        return 0;
      }
    }

    Board tempBoard = board.clone();

    if (pcTurn) {
      int value = -128;
      for (int i = 0; i < 9; i++) {                           // could just get list of indices
        if (tempBoard.isBlank(i)) {
          
          tempBoard.assign(i, "O");
          value = Math.max(value, minimax(tempBoard, depth - 1, false));
        }
      }
      return value;
    } else {                            //minimizing player
      int value = 128;
      for (int i = 0; i < 9; i++) {
        if (tempBoard.isBlank(i)) {
          tempBoard.assign(i, "X");
          value = Math.min(value, minimax(tempBoard, depth - 1, true));
        }
      }
      return value;
    }
  }



  // public int simPlayerTurn(Board board) {
  //   for (int i = 0; i < 9; i++) {
  //     if (board.isBlank(i)) {
  //         int nextplay = simPlayerTurn(board) / 2;
  //     }
  //   }

  //   return 0;
  // }

}
