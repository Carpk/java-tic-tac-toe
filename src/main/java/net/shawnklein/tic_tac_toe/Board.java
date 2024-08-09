package net.shawnklein.tic_tac_toe;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Board {
  static final int WINNING_INDICES[][] = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

  String[] board;
  String huToken;
  String pcToken;
  // String openToken;

  public Board(String[] gameBoard, String pc, String hu) {
    board = gameBoard;
    huToken = hu;
    pcToken = pc;
  }

  public Board clone() {
    return new Board(board.clone(), pcToken, huToken);
  }

  public int availableSpaces() {
    int count = 0;

    for (int i=0; i<board.length; i++) {
        if (isBlank(i)) {
          count++;
        }
    }
    return count;
  }

  // need to check for winning positions or full board
  public boolean isActive() {
    return !isAnyMatch() && !isFull();
  }


  // returns boolean based on playable positions in board
  public boolean isFull() {
    for (String s : board) {
      if (!s.equals(pcToken) && !s.equals(huToken)) { return false; }
    }

    return true;
  }


  // Checks the winning combinations and returns any matching value thats not a blank space.
  public String getWinner() {
    for (int[] i : WINNING_INDICES) {      
        if (!isBlank(i[0]) && board[i[0]].equals(board[i[1]]) && board[i[0]].equals(board[i[2]])) {
          return board[i[0]];
      }
    }

    return "n";
  }

  // Returns boolean based on if there are any winners
  public Boolean isAnyMatch() {
    return getWinner().equals(pcToken) || getWinner().equals(huToken);
  }

  // Takes in index and returns boolean based on if it's available
  public boolean isBlank(int i) {
    return !board[i].equals(pcToken) && !board[i].equals(huToken);
  }

  // Returns boolean based on if the computer won
  public boolean pcWins() {
    return getWinner().equals(pcToken);
  }

  // Returns boolean based on if the player won
  public boolean huWins() {
    return getWinner().equals(huToken);
  }

  // assigns player token to board based on integer
  public void assignHu(int i) {
    board[i] = huToken;
  }

  // assigns computer token to board based on integer
  public void assignPc(int i) {
    board[i] = pcToken;
  }

  // returns a List of all the open positions on a board
  public List<Integer> openIndices() {
    LinkedList<Integer> indices = new LinkedList<Integer>();
    
    for (int i = 0; i < 9; i++) {
        if (board[i].equals(" ")) {
            indices.add(i);  
        }
    }

    return indices;
  }
}
