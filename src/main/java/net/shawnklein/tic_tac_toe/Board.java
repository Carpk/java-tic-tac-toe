package net.shawnklein.tic_tac_toe;

import java.util.Arrays;

public class Board {
  String[] board;
  // int WINNINGINDICES[][] = {{0,1,2},{3,4,5},{6,7,8},
  //                             {0,3,6},{1,4,7},{2,5,8},
  //                             {0,4,8},{2,4,6}};

  public Board(String[] gameBoard) {
    board = gameBoard;

  }

  public Board clone() {
    return new Board(board.clone());
  }

  public int availableSpaces() {
    int count = 0;

    for (int i=0; i<9; i++) {
        if (" " == board[i]) {
          count++;
        }
    }
    return count;
  }

  // need to check for winning positions or full board
  public boolean isActive() {
    return !isAnyMatch() && !isFullBoard();
  }



  // returns boolean based on playable positions in board
  public boolean isFullBoard() {
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
    int winningIndices[][] = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    for (int[] i : winningIndices) {
      if (!board[i[0]].equals(" ") && board[i[0]].equals(board[i[1]]) && board[i[0]].equals(board[i[2]])) {
        return true;
      }
    }

    return false;
  }

  // // possibly change these to return common character
  // public boolean isColMatch() {
  //   boolean a = !board[0].equals(" ") && board[0].equals(board[3]) && board[0].equals(board[6]);
  //   boolean b = !board[1].equals(" ") && board[1].equals(board[4]) && board[1].equals(board[7]);
  //   boolean c = !board[2].equals(" ") && board[2].equals(board[5]) && board[2].equals(board[8]);

  //   return a || b || c;
  // }

  // public boolean isRowMatch() {
  //   String top = board[0];
  //   String mid = board[3];
  //   String bot = board[6];

  //   boolean a = !top.equals(" ") && top.equals(board[1]) && top.equals(board[2]);
  //   boolean b = !mid.equals(" ") && mid.equals(board[4]) && mid.equals(board[5]);
  //   boolean c = !bot.equals(" ") && bot.equals(board[7]) && bot.equals(board[8]);

  //   return a || b || c;
  // }

  // public boolean isDiagMatch() {
  //   boolean a = !board[0].equals(" ") && board[0].equals(board[4]) && board[0].equals(board[8]);
  //   boolean b = !board[2].equals(" ") && board[2].equals(board[4]) && board[2].equals(board[6]);

  //   return a || b;
  // }



  public boolean isBlank(int i) {
    return board[i].equals(" ");
  }

  public boolean pcWins() {
    return getWinner() == "X";
  }

  public void assign(int i, String string) {
    board[i] = string;
  }

  public void printSelf() {
    System.out.println(Arrays.toString(board));
  }
}
