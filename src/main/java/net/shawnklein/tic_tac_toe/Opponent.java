package net.shawnklein.tic_tac_toe;

import java.util.List;

public class Opponent {


  // manages the ai algorithm by deciding is position is appropriate
  // based on heuristic, returns suggsted position
  public int play(Board board) {
    int pos = 0;
    int maxVal = -128;

    for (int i = 0; i < 9; i++) {
      if (board.isBlank(i)) {
        Board tempBoard = board.clone();
        tempBoard.assignPc(i);

        int posValue = minimax(tempBoard, false);

        if (posValue > maxVal) {
          System.out.println("ASSINGING " + i + " for value: " + posValue);
          maxVal = posValue;
          pos = i; 
        }
      }
    }

    return pos;
  }
  
  public Integer boardValue(Board board) {
    if (board.pcWins()) {
      return 128;               
    } else if (board.huWins()) {
      return -128;
    } else {      
      return 0;
    }
  }

  
  public Integer minimax(Board board, Boolean pcTurn) { 
    if (board.isFull() || board.isAnyMatch()) {
      return boardValue(board);
    }

    int val = pcTurn ? -128 : 128;
    List<Integer> indices = board.openIndices();
    for (int i : indices) {
      Board tempBoard = board.clone();  
      // tempBoard.assign(i, pcTurn ? "O" : "X");
      if (pcTurn) {tempBoard.assignPc(i);} else {tempBoard.assignHu(i);}
      int tempVal = minimax(tempBoard, !pcTurn) / 2;
      // if (tempVal > -16 && tempVal < 16 && tempVal != 0) {
      // System.out.println(tempBoard.board + " val: " + tempVal + " at " + depth);
      // }
      val = pcTurn ? Math.max(val, tempVal) : Math.min(val,tempVal);
    }

    return val;
  }

}





  // public Integer minimaxT(Board board, int depth, Boolean pcTurn) {
  //   if (depth == 0 || board.isAnyMatch()) {
  //     return boardValue(board);
  //   }

  //   if (pcTurn) {
  //     System.out.println("PC TURN");
  //     int value = -128;
  //     for (int i = 0; i < 9; i++) {                           // could just get list of indices
  //       if (board.isBlank(i) ) {           // block if unable to beat potential value
  //         Board tempBoard = board.clone(); 
  //         tempBoard.assign(i, "O");
  //         value = Math.max(value, minimax(tempBoard, depth - 1, false)) / 2;
  //       }
  //     }
  //     return value;
  //   } else {                            //minimizing player
  //     System.out.println("HU TURN");
  //     int value = 128;
  //     for (int i = 0; i < 9; i++) {
  //       if (board.isBlank(i)) {
  //         Board tempBoard = board.clone();
  //         tempBoard.assign(i, "X");
  //         value = Math.min(value, minimax(tempBoard, depth - 1, true)) / 2;
  //       }
  //     }
  //     return value;
  //   }
  // }


