package net.shawnklein.tic_tac_toe;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Board {
  String[] board;
  String huToken;
  String pcToken;

  // int WINNINGINDICES[][] = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

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
        if (" ".equals(board[i])) {
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
      if (" ".equals(s)) { return false; }
    }
    // Arrays.asList(board).contains(" ");

    return true;
  }


  // Checks the winning combinations and returns any matching value thats not a blank space.
  public String getWinner() {
    int winningIndices[][] = {{0,1,2},{3,4,5},{6,7,8},
                              {0,3,6},{1,4,7},{2,5,8},
                              {0,4,8},{2,4,6}};

    for (int[] i : winningIndices) {      
        if (!board[i[0]].equals(" ") && board[i[0]].equals(board[i[1]]) && board[i[0]].equals(board[i[2]])) {
          return board[i[0]];
      }
    }

    return "n";
  }

  // Returns boolean based on if there are any winners
  public Boolean isAnyMatch() {
    return !getWinner().equals("n");
  }

  // Takes in index and returns boolean based on if it's available
  public boolean isBlank(int i) {
    return board[i].equals(" ");
  }

  // Returns boolean based on if the computer won
  public boolean pcWins() {
    return getWinner().equals(pcToken);
  }

  // Returns boolean based on if the player won
  public boolean huWins() {
    return getWinner().equals(huToken);
  }

  // assigns a 
  // public void assign(int i, String string) {
  //   board[i] = string;
  // }

  // assigns player token to board based on integer
  public void assignHu(int i) {
    board[i] = huToken;
  }

  // assigns computer token to board based on integer
  public void assignPc(int i) {
    board[i] = pcToken;
  }

  public void printSelf() {
    System.out.println(Arrays.toString(board));
  }

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
