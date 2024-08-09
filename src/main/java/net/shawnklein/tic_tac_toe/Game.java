package net.shawnklein.tic_tac_toe;


public class Game {
  Board board;
  Opponent pc;

  public Game(Board gameboard, Opponent opp) {
    board = gameboard;
    pc = opp;
  }


  // returns string if game is in playable state
  public Boolean isActive() {
    // need to check for winning positions
    return board.isActive();
  }

  // return winner of game
  public String winner() {
    return board.getWinner();
  }


  // returns computer choosen position
  public int playTurn() {    
    return pc.play(board);
  }

  public void updateTurn(int i) {
    board.assignPc(i);
  }




}
