package net.shawnklein.tic_tac_toe;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Board {
  String[] board;
  // int WINNINGINDICES[][] = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

  public Board(String[] gameBoard) {
    board = gameBoard;
  }

  public Board clone() {
    return new Board(board.clone());
  }

  public int availableSpaces() {
    int count = 0;

    for (int i=0; i<9; i++) {
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

  public Boolean isAnyMatch() {
    // int winningIndices[][] = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    // for (int[] i : winningIndices) {
    //   if (!board[i[0]].equals(" ") && board[i[0]].equals(board[i[1]]) && board[i[0]].equals(board[i[2]])) {
    //     return true;
    //   }
    // }

    return !getWinner().equals("n");
  }

  // Takes in index and returns boolean based on if it's available
  public boolean isBlank(int i) {
    return board[i].equals(" ");
  }

  public boolean pcWins() {
    return getWinner().equals("O");
  }

  public boolean huWins() {
    return getWinner().equals("X");
  }

  public void assign(int i, String string) {
    board[i] = string;
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

    // int[] arr = indices.stream().mapToInt(i -> i).toArray();
    return indices;
  }
}
