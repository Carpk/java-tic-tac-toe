package net.shawnklein.tic_tac_toe;


public class Game {
  Board board;

  public Game(String[] gameboard) {
    board = new Board(gameboard);
  }


  // returns boolen if game is in playable state
  public boolean isActive() {
    // need to check for winning positions
    return board.isActive();
  }

  // return winner of game
  public String winner() {
    return board.getWinner();
  }


  // returns computer choosen position
  public int playTurn() {    
    Opponent pc = new Opponent();
    return pc.play(board);
  }














}
