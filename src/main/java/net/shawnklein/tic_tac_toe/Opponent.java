package net.shawnklein.tic_tac_toe;

import java.util.List;

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
        tempBoard.assign(i, "O");

        int posValue = minimax(tempBoard, depth, false);
        System.out.println("RETURNING VAL: " + posValue + " for pos: " + i);         // PRINT FOR DEBUG

        if (posValue > maxVal) {
          maxVal = posValue;
          pos = i; 
        }
      }
    }

    return pos;
  }
  
  public Integer minimax(Board board, int depth, Boolean pcTurn) { 
    if (depth == 0 || board.isAnyMatch()) {
      return boardValue(board);
    }

    List<Integer> indices = board.openIndices();
    for (int i : indices) {
      Board tempBoard = board.clone();  
      tempBoard.assign(i, pcTurn ? "O" : "X");
      return minimax(tempBoard, depth + 1, !pcTurn) / 2;
    }


    // for (int i = 0; i < 9; i++) {             
    //   if (board.isBlank(i) ) {        
    //     Board tempBoard = board.clone();  
    //     tempBoard.assign(i, pcTurn ? "O" : "X");
    //     return minimax(tempBoard, depth + 1, !pcTurn) / 2;
    //   }
    // }

    return 0;
  }


  public Integer minimax_old(Board board, int depth, Boolean pcTurn) {
    if (depth == 0 || board.isAnyMatch()) {
      return boardValue(board);
    }

    Board tempBoard = board.clone();            // I think this is the problem, assingment persists

    if (pcTurn) {
      System.out.println("PC TURN");
      int value = -128;
      for (int i = 0; i < 9; i++) {                           // could just get list of indices
        if (tempBoard.isBlank(i) ) {           // block if unable to beat potential value
          tempBoard.assign(i, "O");
          value = Math.max(value, minimax(tempBoard, depth - 1, false)) / 2;
        }
      }
      return value;
    } else {                            //minimizing player
      System.out.println("HU TURN");
      int value = 128;
      for (int i = 0; i < 9; i++) {
        if (tempBoard.isBlank(i)) {
          tempBoard.assign(i, "X");
          value = Math.min(value, minimax(tempBoard, depth - 1, true)) / 2;
        }
      }
      return value;
    }
  }

  
  public Integer boardValue(Board board) {
    board.printSelf();

    if (board.pcWins()) {
      return 128;               
    } else if (board.huWins()) {
      return -128;
    } else {                                                // need check for tie game, else if pWin r 0
      return 0;
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
